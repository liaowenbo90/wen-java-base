package com.base.threadlock.mulitithreading.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 两个线程同时运行read方法，你会发现两个线程可以同时或者说是几乎同时运行lock()方法后面的代码，
 * 输出的两句话显示的时间一样。这样提高了程序的运行效率。
 */
public class ReentrantReadWriteLockTest {
    /**
     * 1. 读读共享
     */
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();




    public static void main(String [] args) throws InterruptedException {

        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        Thread.sleep(1000);

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

    }



    static public class Service {

        public void read() {
            try {
                try {
                    lock.readLock().lock();
                    System.out.println("获得读锁" + Thread.currentThread().getName()
                            + " " + System.currentTimeMillis());
                    Thread.sleep(10000);
                } finally {
                    lock.readLock().unlock();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        public  void write() {
            try {
                try {
                    lock.writeLock().lock();
                    System.out.println("获得写锁" + Thread.currentThread().getName()
                            + " " + System.currentTimeMillis());
                    Thread.sleep(10000);
                } finally {
                    lock.writeLock().unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static class ThreadA extends Thread {
        private Service service;

        public ThreadA(Service service) {
            super();
            this.service = service;
        }
        @Override
        public void run() {
            super.run();
            service.write();
        }
    }

    public static class ThreadB extends Thread {

        private Service service;

        public ThreadB(Service service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.read();
        }
    }
}
