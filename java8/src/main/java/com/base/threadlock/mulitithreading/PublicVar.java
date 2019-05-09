package com.base.threadlock.mulitithreading;

/**
 * 脏读
 */
public class PublicVar {


    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;

            System.out.println("setValue method thread name="
                    + Thread.currentThread().getName() + " username="
                    + username + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //该方法前加上synchronized关键字就同步了
    synchronized public void getValue() {
        System.out.println("getValue method thread name="
                + Thread.currentThread().getName() + " username=" + username
                + " password=" + password);
    }



    public static class ThreadA extends Thread {

        private PublicVar publicVar;

        public ThreadA(PublicVar publicVar) {
            super();
            this.publicVar = publicVar;
        }

        @Override
        public void run() {
            super.run();
            publicVar.setValue("B", "BB");
        }
    }


    public static class Test {

        public static void main(String[] args) {
            try {
                PublicVar publicVarRef = new PublicVar();
                ThreadA thread = new ThreadA(publicVarRef);
                thread.start();

                Thread.sleep(200);//打印结果受此值大小影响

                publicVarRef.getValue();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }



}
