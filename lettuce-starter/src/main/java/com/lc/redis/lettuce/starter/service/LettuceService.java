package com.lc.redis.lettuce.starter.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by licheng01
 * @date 2025/1/2 13:52
 * @description
 */
@Service
public class LettuceService {

    private final StatefulRedisConnection<String, String> connection;


    public LettuceService(StatefulRedisConnection<String, String> connection) {
        this.connection = connection;
    }

    public void setValue(String key, String value) {
        // 获取同步命令接口
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set(key, value);
    }

    public String getValue(String key) {
        // 获取同步命令接口
        RedisCommands<String, String> syncCommands = connection.sync();
        return syncCommands.get(key);
    }
}
