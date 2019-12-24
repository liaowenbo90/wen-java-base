package com.base.threadlock.mulitithreading;

public class Task2 {

    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);

            String privateGetData1 = "长时间处理任务后从远程返回的值1 threadName="
                    + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2 threadName="
                    + Thread.currentThread().getName();

            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }

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
            Task.CommonUtils.beginTime1 = System.currentTimeMillis();
            task.doLongTimeTask();
            Task.CommonUtils.endTime1 = System.currentTimeMillis();
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
            Task.CommonUtils.beginTime2 = System.currentTimeMillis();
            task.doLongTimeTask();
            Task.CommonUtils.endTime2 = System.currentTimeMillis();
        }
    }


    public static class Run {

        public static void main(String[] args) {
            Task task = new Task();

            Task.MyThread1 thread1 = new Task.MyThread1(task);
            thread1.start();

            Task.MyThread2 thread2 = new Task.MyThread2(task);
            thread2.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long beginTime = Task.CommonUtils.beginTime1;
            if (Task.CommonUtils.beginTime2 < Task.CommonUtils.beginTime1) {
                beginTime = Task.CommonUtils.beginTime2;
            }

            long endTime = Task.CommonUtils.endTime1;
            if (Task.CommonUtils.endTime2 > Task.CommonUtils.endTime1) {
                endTime = Task.CommonUtils.endTime2;
            }

            System.out.println("耗时：" + ((endTime - beginTime) / 1000));
        }
    }
}
