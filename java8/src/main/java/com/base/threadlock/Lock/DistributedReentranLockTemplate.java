package com.base.threadlock.Lock;

import com.base.threadlock.Lock.redislock.CallBack;

/**
 * 分布式锁模板方法类
 * @author liaowb
 * @date 2019-03-21
 */
public interface DistributedReentranLockTemplate {

    public void excute(String lockId, Long timeOut, CallBack callBack);
}
