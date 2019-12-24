package com.base.threadlock.Lock.redislock;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch的使用场景
 * 确保某个计算在其需要的所有资源都被初始化之后才继续执行。
 * 确保某个服务在其依赖的所有其他服务都已启动后才启动。
 * 等待知道某个操作的所有者都就绪在继续执行。
 */
public class CounDown {

    public static void main(String[] args) {

        //所有线程阻塞，然后统一开始
        CountDownLatch begin = new CountDownLatch(1);

        //主线程阻塞，直到所有分线程执行完毕
        CountDownLatch end = new CountDownLatch(5);

        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        begin.await();
                        System.out.println(Thread.currentThread().getName() + " 起跑");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " 到达终点");
                        end.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

            thread.start();
        }

        try {
            System.out.println("1秒后统一开始");
            Thread.sleep(1000);
            begin.countDown();

            end.await();
            System.out.println("停止比赛");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
