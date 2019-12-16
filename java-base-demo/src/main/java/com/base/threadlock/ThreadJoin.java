package com.base.threadlock;

/**
 * join方法。该方法主要作用是在该线程中的run方法结束后，才往下执行
 * @author liaowb
 * @date 2019-03-16
 */
public class ThreadJoin {

    public static void main(String [] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程:" + Thread.currentThread().getId());
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打印主线程信息");

    }
}
