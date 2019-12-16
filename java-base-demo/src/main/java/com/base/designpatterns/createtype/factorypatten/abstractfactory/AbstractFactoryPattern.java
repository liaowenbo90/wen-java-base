package com.base.designpatterns.createtype.factorypatten.abstractfactory;

import com.base.designpatterns.createtype.factorypatten.abstractfactory.factory.FactoryA;
import com.base.designpatterns.createtype.factorypatten.abstractfactory.factory.FactoryB;

/**
 * @author liaowb
 * 步骤6：客户端通过实例化具体的工厂类，并调用其创建不同目标产品的方法创建不同具体产品类的实例
 */
public class AbstractFactoryPattern {

    public static void main(String [] args) {
        FactoryA fa = new FactoryA();
        // A厂 生产模具
        fa.manufactrueMould().show();
        // A 厂 生产容器
        fa.manufactrueContainer().show();
        FactoryB fb = new FactoryB();
        // B 厂 生产模具
        fb.manufactrueMould().show();
        // B 厂 生产容器
        fb.manufactrueContainer().show();
    }
}
