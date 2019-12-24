package com.base.designpatterns.createtype.factorypatten.simplefactory;


import com.base.designpatterns.createtype.factorypatten.simplefactory.factory.Factory;

/**
 * 工厂生产产品流程
 * 外界通过调用工厂类的静态方法，传入不同参数从而创建不同具体产品类的实例
 */
public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Factory factory = new Factory();

        //客户需要A产品
        Factory.manfactrue("A").show();
        //客户需要B产品
        Factory.manfactrue("B").show();
    }


}
