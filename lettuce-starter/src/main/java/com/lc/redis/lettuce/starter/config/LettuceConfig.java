package com.lc.redis.lettuce.starter.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by licheng01
 * @date 2025/1/2 12:08
 * @description
 */
@Configuration
public class LettuceConfig {

    private RedisClient redisClient;
    private StatefulRedisConnection<String, String> connection;

    @Bean
    public StatefulRedisConnection<String, String> redisConnection() {
        // 创建 RedisClient
        redisClient = RedisClient.create("redis://localhost:6379");
        // 创建连接
        connection = redisClient.connect();
        return connection;
    }

    @PreDestroy
    public void shutdown() {
        // 关闭连接
        if (connection != null) {
            connection.close();
        }

        // 关闭客户端
        if (redisClient != null) {
            redisClient.shutdown();
        }
    }
}
