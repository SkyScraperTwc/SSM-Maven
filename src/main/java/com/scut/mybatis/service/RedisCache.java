package com.scut.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
public class RedisCache {

    @Autowired
    private JedisPool jedisPool;
}
