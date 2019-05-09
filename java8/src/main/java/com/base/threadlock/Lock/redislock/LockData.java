package com.base.threadlock.Lock.redislock;

public class LockData {
    /**
     * 当前线程
     */
     Thread owningThread;
    /**\
     * 锁值
     */
    String lockVal;

     public LockData(){

     }

    public LockData(Thread owningThread, String lockVal) {
        this.owningThread = owningThread;
        this.lockVal = lockVal;
    }
}
