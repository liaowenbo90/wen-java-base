package com.base.threadlock.syn;

/**
 * （1）对o实例方法的修饰。
     * 作用的是调用该方法的对象（或者说对象引用）。
     * public synchronized void doSomething(){}
 * ( 2)  对代码块的修饰。
     * 作用的是调用该方法的对象（或者说对象引用）。
     * 		synchronized (this) {
     * 			System.out.println(this);
     * 			amt+=increaseAmt;
     *                }
 * （3）对静态方法的修饰。
     * 作用的是静态方法所在类的所有对象（或者说对象引用）。
     *public synchronized static  void  increaseAmt(float increaseAmt){
 * （4）对类的修饰。
     * 作用的是静态方法所在类的所有对象（或者说对象引用）。
     *
     * 	synchronized (AccountSynchronizedClass.class) {
     * 			amt-=decreaseAmt;
     *                }
 */
public class RunnableDemo implements Runnable {

    private int ticket = 10;

    public RunnableDemo() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {
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

    public static void main(String[] args){
        RunnableDemo runnableDemo = new RunnableDemo();
        //基于火车票创建4个窗口
        System.out.println("基于火车票创建4个窗口");
        new Thread(runnableDemo,"a").start();
        new Thread(runnableDemo,"b").start();
        new Thread(runnableDemo,"c").start();
        new Thread(runnableDemo,"d").start();
    }
}
