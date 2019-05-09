package com.base.threadlock.mulitithreading;

/**
 * synchronized 缺点
 */
public class Task {

    private String getData1;
    private String getData2;

    public synchronized void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 threadName="
                    + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 threadName="
                    + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static class CommonUtils {

        public static long beginTime1;
        public static long endTime1;

        public static long beginTime2;
        public static long endTime2;
    }


    public static class MyThread1 extends Thread {
        private Task task;
        public MyThread1(Task task) {
            super();
            this.task = task;
        }
        @Override
        public void run() {
            super.run();
            CommonUtils.beginTime1 = System.currentTimeMillis();
            task.doLongTimeTask();
            CommonUtils.endTime1 = System.currentTimeMillis();
        }
    }


    public static class MyThread2 extends Thread {
        private Task task;
        public MyThread2(Task task) {
            super();
            this.task = task;
        }
        @Override
        public void run() {
            super.run();
            CommonUtils.beginTime2 = System.currentTimeMillis();
            task.doLongTimeTask();
            CommonUtils.endTime2 = System.currentTimeMillis();
        }
    }


    public static class Run {

        public static void main(String[] args) {
            Task task = new Task();

            MyThread1 thread1 = new MyThread1(task);
            thread1.start();

            MyThread2 thread2 = new MyThread2(task);
            thread2.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long beginTime = CommonUtils.beginTime1;
            if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
                beginTime = CommonUtils.beginTime2;
            }

            long endTime = CommonUtils.endTime1;
            if (CommonUtils.endTime2 > CommonUtils.endTime1) {
                endTime = CommonUtils.endTime2;
            }

            System.out.println("耗时：" + ((endTime - beginTime) / 1000));
        }
    }



}
