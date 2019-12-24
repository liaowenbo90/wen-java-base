package com.base.threadlock.mulitithreading;

/**
 *
 *
 */
public class Service {

    /**
     * “可重入锁”概念是：自己可以再次获取自己的内部锁。比如一个线程获得了某个对象的锁，
     *  * 此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，
     *  * 如果不可锁重入的话，就会造成死锁。
     */

    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }


    public static class MyThread extends Thread {
        @Override
        public void run() {
            Service service = new Service();
            service.service1();
        }

    }


    public static class Run {
        public static void main(String[] args) {
            MyThread t = new MyThread();
            t.start();
        }
    }


    /**
     *静态同步synchronized方法与synchronized(class)代码块
     *
     */

    public static void printA() {
        synchronized (Service.class) {
            try {
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
                Thread.sleep(3000);
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }

    synchronized public void printC() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printC");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printC");
    }


    public static class ThreadA extends Thread {
        private Service service;
        public ThreadA(Service service) {
            super();
            this.service = service;
        }
        @Override
        public void run() {
            service.printA();
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
            service.printB();
        }
    }


    public static class ThreadC extends Thread {
        private Service service;
        public ThreadC(Service service) {
            super();
            this.service = service;
        }
        @Override
        public void run() {
            service.printC();
        }
    }


    public static class Run2 {
        public static void main(String[] args) {
            Service service = new Service();
            Service.ThreadA a = new Service.ThreadA(service);
            a.setName("A");
            a.start();

            Service.ThreadB b = new Service.ThreadB(service);
            b.setName("B");
            b.start();

            Service.ThreadC c = new Service.ThreadC(service);
            c.setName("C");
            c.start();
        }
    }



}
