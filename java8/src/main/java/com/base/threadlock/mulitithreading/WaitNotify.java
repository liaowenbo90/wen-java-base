package com.base.threadlock.mulitithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的第一个等待/通知机制程序
 * 等待/通知机制，是指一个线程A调用了对象O的wait()方法进入等待状态，
 * 而另一个线程B调用了对象O的notify()/notifyAll()方法，线程A收到通知后退出等待队列，
 * 进入可运行状态，进而执行后续操作。上诉两个线程通过对象O来完成交互，而对象上的wait()方法和notify()/notifyAll()
 * 方法的关系就如同开关信号一样，用来完成等待方和通知方之间的交互工作。
 */
public class WaitNotify {

    private static List<String> list = new ArrayList<String>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }



    public static class ThreadA extends Thread {

        private Object lock;

        public ThreadA(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                synchronized (lock) {
                    if (WaitNotify.size() != 5) {
                        System.out.println("wait begin "
                                + System.currentTimeMillis());
                        lock.wait();
                        System.out.println("wait end  "
                                + System.currentTimeMillis());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




    public static class ThreadB extends Thread {
        private Object lock;

        public ThreadB(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        WaitNotify.add();
                        if (WaitNotify.size() == 5) {
                            lock.notify();
                            System.out.println("已发出通知！");
                        }
                        System.out.println("添加了" + (i + 1) + "个元素!");
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




    public static class Run {

        public static void main(String[] args) {

            try {
                Object lock = new Object();

                ThreadA a = new ThreadA(lock);
                a.start();

                Thread.sleep(50);

                ThreadB b = new ThreadB(lock);
                b.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
