package com.base.threadlock.mulitithreading;

/**
 * 线程不共享数据
 */
public class MyThread extends Thread {

    private int count = 5;
    @Override
    public void run() {
        super.run();

//        while(count > 0) {
//            count--;
//
//
//            System.out.println(this.getName() +"运算count:" + count);
//        }

        for (int i = 0; i < 5000000; i++) {
            System.out.println("i=" + (i + 1));
        }


    }


    public static class Run{

        public static void main(String [] args) {
//            MyThread thread1 = new MyThread();
//            MyThread thread2 = new MyThread();
//            MyThread thread3 = new MyThread();
//            thread1.start();
//            thread2.start();
//            thread3.start();
//            System.out.println("运行结束。。。。");



            try {
                MyThread thread = new MyThread();
                thread.start();
                Thread.sleep(2000);
                thread.interrupt();
            } catch (InterruptedException e) {
                System.out.println("main catch");
                e.printStackTrace();
            }

        }
    }


}
