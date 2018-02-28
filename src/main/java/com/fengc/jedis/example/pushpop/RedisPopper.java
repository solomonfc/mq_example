package com.fengc.jedis.example.pushpop;

import com.fengc.jedis.conf.RedisConnection;
import redis.clients.jedis.Jedis;

import static java.lang.Thread.sleep;

public class RedisPopper {

    private static Jedis jedis;
    private static String key = "clist";

    public static void main(String[] args) throws Exception {

        jedis = RedisConnection.getRedisConnection();

        while (true) {
            while (true) {
                String value = jedis.rpop(key);
                if (value == null) {
                    break;
                }
                //System.out.println(value);
            }
            //sleep(5);
        }
    }
}
