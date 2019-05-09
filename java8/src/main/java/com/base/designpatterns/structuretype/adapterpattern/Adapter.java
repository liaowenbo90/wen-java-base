package com.base.designpatterns.structuretype.adapterpattern;

/**
 * @author hasee
 * 步骤3： 创建适配器类（Adapter）
 */
public class Adapter extends Adaptee implements Target  {

    /**
     * 适配器只是将SpecificRequest()方法作了一层封装，封装成Target可以调用的Request()而已
     */
    @Override
    public void request() {
        this.specificRequest();
    }
}
