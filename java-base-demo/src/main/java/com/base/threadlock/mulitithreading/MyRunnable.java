package com.base.threadlock.mulitithreading;

/**
 * 多线程常见的几种方式
 * 实现runable
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable");
    }

    public static class Run{

        public static void main(String [] args) {
            Thread thread = new Thread(new MyRunnable());

            thread.start();
            System.out.println("运行结束 。。");

        }
    }
}
