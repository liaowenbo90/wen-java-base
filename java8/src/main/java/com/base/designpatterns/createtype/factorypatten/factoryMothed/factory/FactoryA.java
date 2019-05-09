package com.base.designpatterns.createtype.factorypatten.factoryMothed.factory;

import com.base.designpatterns.createtype.factorypatten.simplefactory.product.ProductA;

/**
 * @author liaowb
 * 2019-01-07
 * 步骤4：创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法；
 */
public class FactoryA extends Factory {
    @Override
    public ProductA mamufacture() {
        return new ProductA();
    }
}
