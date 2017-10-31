package com.scut.mybatis.controller;

import com.scut.mybatis.entity.ConcurrentBean;
import com.scut.mybatis.service.ConcurrentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/concurrent")
@RestController
@Log4j
public class ConcurrentController {

    @Autowired
    private ConcurrentService concurrentService;

    @Autowired
    private JedisPool jedisPool;

    private Map<String,String> map = new ConcurrentHashMap<>();

    private Set<String> set = new HashSet<>();

    @RequestMapping("/tes1")
    public String tes1(@RequestParam("username")String username,@RequestParam("age") String age) throws InterruptedException {
        System.out.println(username+"------"+age);
        return "success";
    }

    @RequestMapping("/add")
    public String testAdd() throws InterruptedException {
        String uniqueId = Thread.currentThread().getId()+"---"+Thread.currentThread().getName();
        log.info(uniqueId);
        ConcurrentBean concurrentBean = new ConcurrentBean();
        concurrentBean.setName("twc");
        concurrentBean.setAmount(24);
        concurrentService.add(concurrentBean);
        return uniqueId;
    }

    /**
     * 悲观锁
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/updatePessimistic")
    public String updatePessimistic(@RequestParam("username") String username) throws InterruptedException {
            ConcurrentBean concurrentBean = new ConcurrentBean();
            if (concurrentBean.getAmount()>0){
                //判断！！！
            }
            concurrentBean.setId(1004);
            boolean result =  concurrentService.updatePessimistic(concurrentBean);
            if (result){
                map.put(username,"object");
                return String.valueOf(result);
            }else{
                System.out.println(map);
                System.out.println(map.size());
                return "物品已经抢购完！";
            }
    }

    /**
     * 乐观锁，version=${version}版本
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/updatePositive")
    public String updatePositive(@RequestParam("username") String username) throws InterruptedException {
        ConcurrentBean concurrentBean = concurrentService.getById(1004);
        int newAmount = concurrentBean.getAmount() - 1;
        if(newAmount>=0){
            concurrentBean.setAmount(newAmount);
            boolean result =  concurrentService.updatePositive(concurrentBean);
            if (result){
                map.put(username,"object");
            }
            return String.valueOf(result);
        }else {
            System.out.println(map);
            System.out.println(map.size());
            return "物品已经抢购完！";
        }
    }

    /**
     * 乐观锁，${version}>version版本
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/updatePositive2")
    public String updatePositive2(@RequestParam("username") String username) throws InterruptedException {
        ConcurrentBean concurrentBean = concurrentService.getById(1004);
        int newAmount = concurrentBean.getAmount() - 1;
        int newVersion = concurrentBean.getVersion() + 1;
        if(newAmount>=0){
            concurrentBean.setAmount(newAmount);
            concurrentBean.setVersion(newVersion);
            boolean result = concurrentService.updatePositive2(concurrentBean);
            if (result){
                map.put(username,"object");
            }
            return String.valueOf(result);
        }else {
            System.out.println(map);
            System.out.println(map.size());
            return "物品已经抢购完！";
        }
    }

    @RequestMapping("/testRedisDecr")
    public String testRedisDecr(@RequestParam("username") String username, @RequestParam("age") int age) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        //原子操作
        Long result = jedis.decr("num");
        synchronized (this){
            if(result>=0){
                System.out.println("-----------------");
                set.add(username);
                System.out.println("result----"+result);
                System.out.println("size---"+set.size());
                System.out.println("-----------------");
            }
        }
        return username+"---"+age;
    }

    @RequestMapping("/testRedisWatch")
    public String testRedisWatch(@RequestParam("username") String username, @RequestParam("age") int age) throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        String flag = "";
        //watch要放这里！
        jedis.watch("accountBalance");
        // 观察 总标值，每人抢购一元
        // 判断是否购买过
        Boolean isBuy = jedis.sismember("usernameSet", username);
        if (isBuy) {
            flag = "username----已经购买过了!!";
            return flag;
        }
        //投资额
        int r = 1;
        int lastAccount = 0;
        String balance = jedis.get("accountBalance");
        if (balance.length()>0) {
            lastAccount = Integer.valueOf(balance) - r;
        }
        if (lastAccount < 0) {
            flag = "username----物品抢购完了！！";
        }else{
            Transaction tx = jedis.multi();
            tx.set("accountBalance", lastAccount + "");
            List<Object> result = tx.exec();

            if (result == null || result.isEmpty()) {
                flag = "watch监控被更改过----物品抢购失败！！";
                //上面执行过exec()了，不需要再执行unwatch()
                jedis.unwatch();
            } else {
                System.out.println("恭喜您，" + username + "已经中标" + r + "元,标余额" + lastAccount + "元");
                jedis.sadd("usernameSet", username + "");
                flag = "抢购成功!!";
            }
        }
        return flag;
    }
}
     