package com.base.threadlock.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executor框架是一个根据一组执行策略调用，调度，执行和控制的异步任务的框架，目的是提供一种将”任务提交”与”任务如何运行”分离开来的机制。
 *
 * J.U.C中有三个Executor接口：
 *
 * Executor：一个运行新任务的简单接口；
 * ExecutorService：扩展了Executor接口。添加了一些用来管理执行器生命周期和任务生命周期的方法；
 * ScheduledExecutorService：扩展了ExecutorService。支持Future和定期执行任务。
 *
 */
public class TestThreadPool {

    private static int produceTaskSleepTime = 2;

    private static int produceTaskMaxNumber = 10;

    public static void main(String [] args) {
        /**
         * corePoolSize： 线程池维护线程的最少数量
         *
         * maximumPoolSize：线程池维护线程的最大数量
         *
         * keepAliveTime： 线程池维护线程所允许的空闲时间
         *
         * unit： 线程池维护线程所允许的空闲时间的单位
         *
         * workQueue： 线程池所使用的缓冲队列
         *
         * handler： 线程池对拒绝任务的处理策略
         */
        //构造一个线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,4,3,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(3));
            for(int i = 1; i<= produceTaskMaxNumber;i++) {
                try{
                    String task = "task@" + i;
                    System.out.println("创建任务并提交到线程池中：" + task);
                    poolExecutor.execute(new ThreadPoolTask(task));
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }
}
