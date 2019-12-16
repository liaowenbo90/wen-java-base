package com.base.designpatterns.createtype.factorypatten.simplefactory.product;


/**
 * 产品实例A
 *
 * @author liaowb
 * 2019-01-07
 * 创建具体产品类（继承抽象产品类） & 定义生产的具体产品；
 */
public class ProductA extends Product {

    @Override
    public void show() {
        System.out.println("生产了A产品");
    }

}
