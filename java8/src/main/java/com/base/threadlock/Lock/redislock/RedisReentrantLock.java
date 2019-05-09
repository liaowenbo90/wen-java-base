package com.base.threadlock.Lock.redislock;

import com.base.threadlock.Lock.DistributedReentrantLock;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * redis 分布式锁
 * @author liaowb
 * @date 2019-03-19
 */
public class RedisReentrantLock implements DistributedReentrantLock {
    /**
     * 相比较于 HashTable 和由同步包装器包装的 HashMap每次只能有一个线程执行读或写操作，ConcurrentHashMap 在并发访问性能上有了质的提高。
     * 在理想状态下，ConcurrentHashMap 可以支持 16 个线程执行并发写操作（如果并发级别设置为 16），及任意数量线程的读操作。
     */
    private final Map<Thread,LockData> threadData = new ConcurrentHashMap<>();
    // 线程池
    private JedisPool pool;
    // 锁id
    private String lockId;
    //等待时间
    private int waitTime=300;
    // 超时时间
    private int lockTimeOut = 2000;
    public RedisReentrantLock(JedisPool pool, String lockId) {
        this.pool = pool;
        this.lockId = lockId;
    }





    private String getTryRedisLock(String lockId, long timeout) {
        //当前系统时间
        long startMillis = System.currentTimeMillis();
        String lockValue = null;

        while(lockValue == null) {

            lockValue = createRedisKey(lockId);
            if(lockValue != null) {
                System.out.println("createRedisKey.lockValue:" + lockValue);
                break;
            }
            if(System.currentTimeMillis() - startMillis - waitTime > timeout) {
                System.out.println("currentTimeMillis:" + System.currentTimeMillis() + "startMillis:"
                        + startMillis + "waitTime:" +waitTime + "timeout:" + timeout);
                break;
            }

        }
        System.out.println("lockValue:" + lockValue);
        return lockValue;
    }
    private final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};

    private String randomId(int size) {
        char[] cs = new char[size];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = digits[ThreadLocalRandom.current().nextInt(digits.length)];
        }
        return new String(cs);
    }

    /**
     * 创建rediskey
     * @param lockId
     * @return
     */
    public  String createRedisKey(String lockId) {
        Jedis jedis = null;
//        String lockValue = lockId + new Random(123456);
        try {

            jedis = pool.getResource();
            System.out.println("jedis.ping():" + jedis.ping());
            String luaScript = ""
                    + "\nlocal r = tonumber(redis.call('SETNX', KEYS[1],ARGV[1]));"
                    + "\nredis.call('PEXPIRE',KEYS[1],ARGV[2]);"
                    + "\nreturn r";
            String value = lockId + randomId(1);//new Random().nextInt(1234565645);
            List<String> keys = new ArrayList<String>();
            keys.add(lockId);
            List<String> args = new ArrayList<String>();
            args.add(value);
            args.add(lockTimeOut+"");
            Long eval = (Long)jedis.eval(luaScript, keys, args);

            if(new Long(1).equals(eval)) {
                return value;
            }
        }finally {
            jedis.close();
        }

        return null;
    }

    public static  void main(String [] args) {
//        String asdfg = (String) createRedisKey("asdfg");
//
//        System.out.println(asdfg);

        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        Jedis jedis = jedisPool.getResource();
//        String lockValue = lockId + new Random(123456);
        try {

            jedis = jedisPool.getResource();
            System.out.println("jedis.ping():" + jedis.ping());
            String luaScript = ""
                    + "\nlocal r = tonumber(redis.call('SETNX', KEYS[1],ARGV[1]));"
                    + "\nredis.call('PEXPIRE',KEYS[1],ARGV[2]);"
                    + "\nreturn r";
            String value = "订单流水" + new Random().nextInt(1234565645);
            List<String> keys = new ArrayList<String>();
            keys.add("订单流水");
            List<String> arg = new ArrayList<String>();
            arg.add(value);

            Long eval = (Long)jedis.eval(luaScript, keys, arg);
            System.out.println("jedis.get()" + jedis.get(arg.get(1)));
            if(new Long(1).equals(eval)) {
                System.out.println("value:" + value);
            }
        }finally {
            jedis.close();
        }

    }


    @Override
    public boolean tryLock(long timeout) {
        //取到锁返回true ,没取到返回false
        Thread thread = Thread.currentThread();
        LockData lockData = threadData.get(thread);
        if(lockData != null) {
            System.out.println("拿到锁了。。。。");
            return true;
        }
        // 读取锁的值
        String lockVal = getTryRedisLock(lockId,timeout);
        if(lockVal != null) {
            threadData.put(thread,new LockData(thread,lockVal));
            System.out.println("拿到锁了。。。。");
            return true;
        }
        System.out.println("没拿到锁。。。。");
        return false;
    }

    @Override
    public void unLock() {

    Thread currentThread = Thread.currentThread();
        LockData lockValue = threadData.get(currentThread);
        if(lockValue == null) {
            throw new IllegalMonitorStateException("you not won lock" + lockId);
        }
        try {

            unlockRedisLock(lockId, lockValue);
        }finally {
            threadData.remove(currentThread);

        }
        System.out.println("释放锁了。。。。");

    }

    void unlockRedisLock(String key,LockData lockData) {
        Jedis jedis = null;
        boolean broken = false;
        try {
            jedis = pool.getResource();
            String luaScript=""
                    +"\nlocal v = redis.call('GET', KEYS[1]);"
                    +"\nlocal r= 0;"
                    +"\nif v == ARGV[1] then"
                    +"\nr =redis.call('DEL',KEYS[1]);"
                    +"\nend"
                    +"\nreturn r";
            List<String> keys = new ArrayList<String>();
            keys.add(key);
            List<String> args = new ArrayList<String>();
            args.add(lockData.lockVal);
            Object r=jedis.eval(luaScript, keys, args);
        } finally {
            if(jedis!=null) {jedis.close();}
        }
    }
}
