package com.base.designpatterns.structuretype.proxypattern;

/**
 * @author liaowb
 * @date 2019-10-14
 * 步骤2： 创建真实对象类（RealSubject）,即”我“
 */
public class RealSubjcet implements Subject {

    @Override
    public void buyMac() {
        System.out.println("买一台Mac");
    }
}
