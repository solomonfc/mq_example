package com.fengc.jedis.conf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {

    public static String host = "192.168.242.132";
    public static int port = 7000;
    public static String password = "h@HZI7SyC6v23QkL2&BV6^dfe7OUufW3";

    public static Jedis getRedisConnection() {
        System.out.println(host+":"+port+" with "+password);
        Jedis jedis = new Jedis(host, port);
        jedis.auth(password);
        return jedis;
    }

    public static JedisPool getJedisPool() {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), host, port, 1000, password);
        return jedisPool;
    }
}
