package redismq;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Random;

public class TaskConsumer implements Runnable{
    Jedis jedis = new Jedis("127.0.0.1",6379);

    @Override
    public void run() {
        Random random = new Random();
        while(true){
            //从任务队列"task-queue"中获取一个任务，并将该任务放入暂存队列"tmp-queue"
            String taskid = jedis.rpoplpush("task-queue", "tmp-queue");
            try {
                // 处理任务----纯属业务逻辑，模拟一下：睡觉
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //模拟成功和失败的偶然现象
            if(random.nextInt(13) % 7 == 0){// 模拟失败的情况,概率为2/13
                //将本次处理失败的任务从暂存队列"tmp-queue"中，弹回任务队列"task-queue"
                jedis.rpoplpush("tmp-queue", "task-queue");
                System.out.println(taskid + "处理任务失败，被弹回任务队列");

            } else {// 模拟成功的情况
                // 将本次任务从暂存队列"tmp-queue"中清除
                List<String> list = jedis.brpop(0,"tmp-queue");
                System.out.println(list.get(1)+"处理成功，被清除");
            }
        }
    }
}
