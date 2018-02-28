package com.fengc.jedis.example.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSubscriberThread extends Thread {

    private final JedisPool jedisPool;
    private final JedisSubscriber subscriber = new JedisSubscriber();

    private final String channel;

    public JedisSubscriberThread(JedisPool jedisPool, String channel) {
        this.jedisPool = jedisPool;
        this.channel = channel;
    }

    @Override
    public void run() {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(subscriber, channel);
        } catch (Exception e) {
            System.out.println(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}