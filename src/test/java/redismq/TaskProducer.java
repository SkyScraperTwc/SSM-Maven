package redismq;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;

public class TaskProducer implements Runnable{
    Jedis jedis = new Jedis("127.0.0.1",6379);

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                Thread.sleep(random.nextInt(600)+600);
                UUID taskid = UUID.randomUUID();
                jedis.lpush("task-queue",taskid.toString());
                System.out.println("插入了一个新的任务： " + taskid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
