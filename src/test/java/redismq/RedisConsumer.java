package redismq;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisConsumer implements Runnable{
    Jedis jedis = new Jedis("127.0.0.1", 6379);

    @Override
    public void run() {
        while (true){
            //阻塞式brpop，List中无数据时阻塞
            //参数0表示一直阻塞下去，直到List出现数据
            try {
                Thread.sleep(1500);
                List<String> list = jedis.brpop(0, "informList");
                System.out.println(list.get(1)+"处理成功，被清除");
                jedis.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
