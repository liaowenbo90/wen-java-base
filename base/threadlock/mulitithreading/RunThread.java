package com.base.threadlock.mulitithreading;

/**
 * volatile关键字的可见性
 *
 * RunThread类中的isRunning变量没有加上volatile关键字时，运行以上代码会出现死循环，
 * 这是因为isRunning变量虽然被修改但是没有被写到主存中，这也就导致该线程在本地内存中的值一直为true，这样就导致了死循环的产生。
 *
 * 解决办法也很简单：isRunning变量前加上volatile关键字即可。
 */
public class RunThread extends Thread {

    volatile private boolean isRunning = true;
    int m;
    public boolean isRunning() {
        return isRunning;
    }
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) {
            int a=2;
            int b=3;
            int c=a+b;
            m=c;
            System.out.println("isRunning:"+isRunning);
        }
        System.out.println(m);
        System.out.println("线程被停止了！");
    }



    public static class Run {
        public static void main(String[] args) throws InterruptedException {
            RunThread thread = new RunThread();

            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);

            System.out.println("已经赋值为false");
        }
    }


public static class Mythread extends Thread {

    volatile public static int count;

     synchronized private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        System.out.println("count=" + count);

    }

    @Override
    public void run() {
        addCount();
    }


    public static  class Run3 {
        public static void main(String[] args) {
            Mythread[] mythreadArray = new Mythread[100];
            for (int i = 0; i < 100; i++) {
                mythreadArray[i] = new Mythread();
            }

            for (int i = 0; i < 100; i++) {
                mythreadArray[i].start();
            }
        }

    }

}
}

