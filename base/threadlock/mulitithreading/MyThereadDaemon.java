package com.base.threadlock.mulitithreading;

/**
 * 1.  setDaemon(true)必须在start（）方法前执行，否则会抛出IllegalThreadStateException异常
 * 2. 在守护线程中产生的新线程也是守护线程
 * 3. 不是所有的任务都可以分配给守护线程来执行，比如读写操作或者计算逻辑
 */
public class MyThereadDaemon extends Thread {

        private int i = 0;

        @Override
        public void run() {
            try {
                while (true) {
                    i++;
                    System.out.println("i=" + (i));
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



    public static class Run {
        public static void main(String[] args) {
            try {
                MyThereadDaemon thread = new MyThereadDaemon();
                thread.setDaemon(true);
                thread.start();
                Thread.sleep(5000);
                System.out.println("我离开thread对象也不再打印了，也就是停止了！");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
