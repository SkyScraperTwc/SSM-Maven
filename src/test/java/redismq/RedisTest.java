package redismq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:conf/spring-core.xml"})
public class RedisTest {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testQuery() throws InterruptedException {
        // 启动一个生产者线程，模拟任务的产生
        new Thread(new TaskProducer()).start();

        Thread.sleep(10000);

        //启动一个线程者线程，模拟任务的处理
        new Thread(new TaskConsumer()).start();

        //主线程休眠
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void testQuery2() throws InterruptedException {
        // 启动一个生产者线程，模拟任务的产生
        new Thread(new RedisProducer()).start();

        Thread.sleep(10000);

        //启动一个消费者线程，模拟任务的处理
        new Thread(new RedisConsumer()).start();

        //主线程休眠
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void testQuery3() throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.rpop("task-queue");
        System.out.println(result);
    }

    @Test
    public void testQuery4() throws InterruptedException {
        Jedis jedis = jedisPool.getResource();
        List<String> list = jedis.brpop(5,"task-queue");
        System.out.println(list.isEmpty());
        System.out.println(list==null);
    }
}
