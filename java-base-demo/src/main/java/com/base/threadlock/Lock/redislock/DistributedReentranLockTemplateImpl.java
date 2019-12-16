package com.base.threadlock.Lock.redislock;

import com.base.threadlock.Lock.DistributedReentranLockTemplate;
import com.base.threadlock.Lock.DistributedReentrantLock;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ThreadLocalRandom;

public class DistributedReentranLockTemplateImpl implements DistributedReentranLockTemplate {


    private JedisPool jedisPool;


    public DistributedReentranLockTemplateImpl(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    @Override
    public void excute(String lockId, Long timeOut, CallBack callBack) {
        DistributedReentrantLock distributedReentrantLock = null;
            boolean getLock = false;
        distributedReentrantLock = new RedisReentrantLock(jedisPool,lockId);
        try{

            if(distributedReentrantLock.tryLock(timeOut)){
                callBack.getLock();
                getLock = true;
            }else {

                callBack.timeOut();
            };
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(getLock) {
                distributedReentrantLock.unLock();
            }
        }

    }

    public static void main (String [] args) {

        final int sleepTime=ThreadLocalRandom.current().nextInt(5)*1000;

        System.out.println("sleepTime:" + sleepTime);


    }
}
