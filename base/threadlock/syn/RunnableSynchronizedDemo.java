package com.base.threadlock.syn;

/**
 * synchronized这个关键字有两种用法1、放方法名前形成同步方法；2、放在块前构成同步块。
 */
public class RunnableSynchronizedDemo   implements Runnable  {

    private int ticket = 10;

    public RunnableSynchronizedDemo() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sale();


        }

    }

    private synchronized void sale() {
        if(ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "号窗口卖出" + this.ticket-- + "票");
        }
    }

    public static void main(String[] args){
        RunnableSynchronizedDemo runnableDemo = new RunnableSynchronizedDemo();
        //基于火车票创建4个窗口
        System.out.println("基于火车票创建4个窗口");
        new Thread(runnableDemo,"a").start();
        new Thread(runnableDemo,"b").start();
        new Thread(runnableDemo,"c").start();
        new Thread(runnableDemo,"d").start();
    }
}
