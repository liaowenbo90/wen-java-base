package com.base.designpatterns.createtype.factorypatten.factoryMothed;

import com.base.designpatterns.createtype.factorypatten.factoryMothed.factory.FactoryA;
import com.base.designpatterns.createtype.factorypatten.factoryMothed.factory.FactoryB;
/**
 * @author liaowb
 * @date 2019-01-07
 * 步骤5：外界通过调用具体工厂类的方法，从而创建不同具体产品类的实例
 */
public class Factorypatten {

    public static void main(String[] args) {

        //客户需要A产品
        FactoryA factoryA = new FactoryA();
        factoryA.mamufacture().show();

        //客户需要B产品
        FactoryB factoryb = new FactoryB();
        factoryb.mamufacture().show();

    }

}
