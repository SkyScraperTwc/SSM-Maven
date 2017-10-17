package com.scut.mybatis.controller;

import com.scut.mybatis.entity.ConcurrentBean;
import com.scut.mybatis.service.ConcurrentService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/concurrent")
@RestController
@Log4j
public class ConcurrentController {

    @Autowired
    private ConcurrentService concurrentService;

    private Map<String,String> map = new ConcurrentHashMap<String, String>();

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
     * 乐观锁
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

    @RequestMapping("/testJMeterParam")
    public String testJMeterParam(@RequestParam("username") String username, @RequestParam("age") int age) throws InterruptedException {
        log.info(username+"---"+age);
        return username+"---"+age;
    }
}
     