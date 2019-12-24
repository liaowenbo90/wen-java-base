package com.base.threadlock.Lock.redislock;


/**
 * @author liaowb
 * @date 2019-03-18
 */
public class RedisPool {
    //jedis连接池
    private static RedisPool pool;
    //最大连接数
    private static int maxTotal = 20;
   //最大空闲连接数
    private static int maxIdle = 10;
    // 最小空闲连接数
    private static  int minIdle = 5;
    //在取连接时测试连接可用性
    private static boolean testOnBorrow = true;
    //在还连接时不测试连接可用性
    private static boolean isTestOnBorrow = false;

    static {
        //初始化连接池
        initPool();
    }

//    public static Jedis getJedis(){
//        return pool.r
//    }

    /**
     * 初始化连接池
     */
    private static void initPool() {
    }


}
