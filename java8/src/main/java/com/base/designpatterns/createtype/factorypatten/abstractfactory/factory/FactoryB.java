package com.base.designpatterns.createtype.factorypatten.abstractfactory.factory;

import com.base.designpatterns.createtype.factorypatten.abstractfactory.product.ContainerProductB;
import com.base.designpatterns.createtype.factorypatten.abstractfactory.product.MouldProductB;
import com.base.designpatterns.createtype.factorypatten.simplefactory.product.Product;

/**
 * @author liaowb
 * B厂 - 生产模具+容器产品
 */
public class FactoryB extends Factory {

    @Override
    public Product manufactrueContainer() {
        return  new ContainerProductB();
    }

    @Override
    public Product manufactrueMould() {
        return new MouldProductB();
    }
}
