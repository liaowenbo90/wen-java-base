package com.base.threadlock.threadpoolexecutor;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {

    private Object attachData;


    public ThreadPoolTask(Object attachData) {
        this.attachData = attachData;
    }

    public Object getAttachData() {
        return attachData;
    }

    @Override
    public void run() {

        System.out.println("开始执行任务：" + attachData);
        attachData = null;

    }


}
