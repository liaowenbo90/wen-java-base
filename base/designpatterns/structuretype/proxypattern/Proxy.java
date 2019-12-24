package com.base.designpatterns.structuretype.proxypattern;

/**
 * @author liaowb
 * @date 2019-01-14
 * 步骤3：创建代理对象类（Proxy），即”代购“，并通过代理类创建真实对象实例并访问其方法
 */
public class Proxy implements Subject {

    @Override
    public void buyMac() {
        //引用并创建真实对象的实例
        RealSubjcet realSubjcet = new RealSubjcet();
        //调用真实对象的方法进行代理购买Mac
        realSubjcet.buyMac();
        this.wrapMac();
    }
    public void wrapMac(){
        System.out.println("用盒子包装Mac");
    }
}
