package redismq;

import redis.clients.jedis.Jedis;

import java.util.UUID;

public class RedisProducer implements Runnable{
    Jedis jedis = new Jedis("127.0.0.1", 6379);

    @Override
    public void run() {
        while (true){
            try {
                UUID taskid = UUID.randomUUID();
                Thread.sleep(1000);
                jedis.lpush("informList",taskid.toString());
                System.out.println("RedisProducer插入了一个新的任务： " + taskid);
                jedis.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
