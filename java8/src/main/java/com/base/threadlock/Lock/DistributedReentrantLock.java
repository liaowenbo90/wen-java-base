package com.base.threadlock.Lock;

/**
 * 分布式锁
 * 主要 有 获取锁、释放锁
 * @author liaowb
 * @date 2019-03-19
 */
public interface DistributedReentrantLock {
    /**
     *非阻塞获取锁
     * @param timeout
     * @return
     */
    public boolean tryLock(long timeout);

    /**
     * 释放锁
     */
    public void unLock();
}
