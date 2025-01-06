package com.lc.redis.jedis.starter.service;

/**
 * @author by licheng01
 * @date 2024/12/25 20:17
 * @description
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public void set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
    }

    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }
}
