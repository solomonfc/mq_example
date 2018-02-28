package com.fengc.jedis.example.pushpop;

import com.fengc.jedis.conf.RedisConnection;
import redis.clients.jedis.Jedis;

import static java.lang.Thread.sleep;

public class RedisPusher {

    private static Jedis jedis;

    public static void main(String[] args) throws Exception {

        jedis = RedisConnection.getRedisConnection();

        while (true) {

            long cTime = System.currentTimeMillis();
            jedis.lpush("jlist", Long.toString(cTime));
            sleep(10);
        }
    }
}
