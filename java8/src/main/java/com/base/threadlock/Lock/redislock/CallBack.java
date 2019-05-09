package com.base.threadlock.Lock.redislock;

public interface CallBack {

    public void getLock() throws InterruptedException;

    public void timeOut() throws InterruptedException;
}
