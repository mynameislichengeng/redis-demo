package org.example.lc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 配置 Jedis 连接池参数
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(5);
        return new JedisPool(jedisPoolConfig, host, port, 3000);
    }
}
