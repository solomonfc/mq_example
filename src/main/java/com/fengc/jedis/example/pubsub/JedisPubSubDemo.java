package com.fengc.jedis.example.pubsub;

import com.fengc.jedis.conf.RedisConnection;
import redis.clients.jedis.JedisPool;

public class JedisPubSubDemo {

    public static void main( String[] args )
    {
        JedisPool jedisPool = RedisConnection.getJedisPool();
        String channel = "jChannel";

        JedisSubscriberThread subThread = new JedisSubscriberThread(jedisPool, channel);
        subThread.start();

        JedisPublisher publisher = new JedisPublisher(jedisPool, channel);
        publisher.start();
    }
}
