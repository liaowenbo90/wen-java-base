package com.base.designpatterns.createtype.factorypatten.abstractfactory.factory;

import com.base.designpatterns.createtype.factorypatten.abstractfactory.product.ContainerProductA;
import com.base.designpatterns.createtype.factorypatten.abstractfactory.product.MouldProductA;
import com.base.designpatterns.createtype.factorypatten.simplefactory.product.Product;

/**
 * @author liaowb
 * A厂 - 生产模具+容器产品
 */
public class FactoryA extends Factory {

    @Override
    public Product manufactrueContainer() {
        return new ContainerProductA();
    }

    @Override
    public Product manufactrueMould() {
        return  new MouldProductA();
    }
}
