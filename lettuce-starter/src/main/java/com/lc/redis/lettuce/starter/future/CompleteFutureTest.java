package com.lc.redis.lettuce.starter.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author by licheng01
 * @date 2025/1/3 16:12
 * @description
 */
public class CompleteFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture<Long> ff = future.thenApply(str -> {
            try {
                System.out.println("---thenApply():" + System.currentTimeMillis());
                Thread.sleep(1000 * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Long.valueOf(str);
        });
        try {
            new Thread(() -> {
                try {
                    System.out.println("---complete():" + System.currentTimeMillis());
                    Thread.sleep(1000 * 10);
                    future.complete("123");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            Long v = ff.get();
            System.out.println(v);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
