package com.base.designpatterns.createtype.factorypatten.factoryMothed.factory;


import com.base.designpatterns.createtype.factorypatten.simplefactory.product.Product;

/**
 * @author liaowb
 * @date 2019-01-07
 * 步骤1： 创建抽象工厂类，定义具体工厂的公共接口；
 */
public abstract class Factory {
    /**
     * 抽象生产
     *
     * @return
     */
    public abstract Product mamufacture();


}
