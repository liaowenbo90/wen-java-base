package com.base.threadlock.mulitithreading.Executor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 使用ScheduledExecutorService和ScheduledThreadPoolExecutor实现的java调度程序示例程序。
 *
 * 使用 DelayQueue 作为任务队列；
 * 获取任务的方不同
 * 执行周期任务后，增加了额外的处理
 * 、
 *
 * 1线程1从DelayQueue中获取已到期的ScheduledFutureTask（DelayQueue.take()）。
 * 到期任务是指ScheduledFutureTask的time大于等于当前系统的时间；
 * 2线程1执行这个ScheduledFutureTask；
 * 3线程1修改ScheduledFutureTask的time变量为下次将要被执行的时间；
 * 4线程1把这个修改time之后的ScheduledFutureTask放回DelayQueue中（DelayQueue.add())。
 *
 */
public class ScheduledThreadPoolDemo {


    public static void main(String[] args) throws InterruptedException {

        //创建一个ScheduledThreadPoolExecutor对象
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //计划在某段时间后运行
        System.out.println("Current Time = "+new Date());
        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing");
            //创建并执行在给定延迟后启用的单次操作。
            scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
        }

        //添加一些延迟让调度程序产生一些线程
        Thread.sleep(30000);
        System.out.println("Current Time = "+new Date());
        //关闭线程池
        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
            //等待所有任务完成
        }
        System.out.println("Finished all threads");
    }
}
