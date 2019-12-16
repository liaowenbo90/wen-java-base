package com.base.threadlock.syn;

/**
 * synchronized这个关键字有两种用法1、放方法名前形成同步方法；2、放在块前构成同步块。
 */
public class RunnableSynchronizedDemo2 implements Runnable {

    private int ticket = 100;

    public RunnableSynchronizedDemo2() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 200 ; i++) {

            synchronized (RunnableSynchronizedDemo2.class) {
                if(ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "号窗口卖出" + this.ticket-- + "票");
                }
            }


        }

    }

    private  void sale() {

    }

    public static void main(String[] args){
        RunnableSynchronizedDemo2 runnableDemo = new RunnableSynchronizedDemo2();
        //基于火车票创建4个窗口
        System.out.println("基于火车票创建4个窗口");
        new Thread(runnableDemo,"a").start();
        new Thread(runnableDemo,"b").start();
        new Thread(runnableDemo,"c").start();
        new Thread(runnableDemo,"d").start();
    }
}
