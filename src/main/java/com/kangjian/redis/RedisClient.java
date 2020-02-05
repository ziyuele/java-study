/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

public class RedisClient {

    private  Jedis jedis;
    public RedisClient() {
        init();
    }

    public void init() {
        this.jedis = new Jedis("140.143.132.21", 6379, 100);
    }

    /**
     *  往redis 设置String
     */
    void setGetString() {
        String value = "hahahaha";
        String key = "TestKey";
        jedis.append(key, value);
        String ret = jedis.get(key);
        System.out.println(ret);
        long ret1 = jedis.del(key);
        System.out.println(ret1);
    }


    void setGetHash() {
        long  ret  = 0L;
        ret = jedis.hset("hasSetKey", "name", "kangjian");
        System.out.println(ret);
        String res = jedis.hget("hasSetKey", "name");
        System.out.println(res);
        ret = jedis.hlen("hasSetKey");
        System.out.println(ret);
        ret = jedis.hdel("hasSetKey", "name");
        System.out.println(ret);
        ret = jedis.hlen("hasSetKey");
        System.out.println(ret);
    }

    void setGetList() {
        jedis.lpush("ListKey", "one", "two");
        jedis.lpush("ListKey", "three", "four");
        String ret = jedis.lpop("ListKey");
        System.out.println(ret);
    }

    void setGetSet() {
        jedis.sadd("setKey", "value1", "value2");
        Set<String> set  = jedis.sunion("setKey");
        System.out.println(set);

    }


    void getSetSortedSet() {
        jedis.zadd("sortedSetKey", 1, "value1");
        jedis.zadd("sortedSetKey", 2, "value2");
        jedis.zadd("sortedSetKey", 3, "value3");
        Set<String> ret = jedis.zrange("sortedSetKey", 0, 3);
        System.out.println(ret);
    }

    public static void main(String args[]) {
        RedisClient redisClient = new RedisClient();
        // String
        redisClient.setGetString();
        System.out.println("+-------------------------------+");
        // hash
        redisClient.setGetHash();
        System.out.println("+-------------------------------+");

        // List
        redisClient.setGetList();

        System.out.println("+-------------------------------+");
        // set
        redisClient.setGetSet();
        System.out.println("+-------------------------------+");
        redisClient.getSetSortedSet();
        System.out.println("+-------------------------------+");
    }


}
