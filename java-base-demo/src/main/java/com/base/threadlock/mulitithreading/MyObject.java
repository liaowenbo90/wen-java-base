package com.base.threadlock.mulitithreading;

/**
 * synchronized 代码块间的使用
 * 监视同一个对象
 */
public class MyObject {

    public static class Service {

        public void testMethod1(MyObject object) {
            synchronized (object) {
                try {
                    System.out.println("testMethod1 ____getLock time="
                            + System.currentTimeMillis() + " run ThreadName="
                            + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("testMethod1 releaseLock time="
                            + System.currentTimeMillis() + " run ThreadName="
                            + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static class ThreadA extends Thread {

        private Service service;
        private MyObject object;

        public ThreadA(Service service, MyObject object) {
            super();
            this.service = service;
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            service.testMethod1(object);
        }
    }


    public static class ThreadB extends Thread {
        private Service service;
        private MyObject object;

        public ThreadB(Service service, MyObject object) {
            super();
            this.service = service;
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            service.testMethod1(object);
        }

    }


    public static class Run1_1 {

        public static void main(String[] args) {
            Service service = new Service();
            MyObject object = new MyObject();

            ThreadA a = new ThreadA(service, object);
            a.setName("a");
            a.start();

            ThreadB b = new ThreadB(service, object);
            b.setName("b");
            b.start();
        }
    }


}
