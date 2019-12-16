package com.base.designpatterns.createtype.factorypatten.abstractfactory.product;

/**
 * 步骤4： 创建具体产品类（继承抽象产品类）， 定义生产的具体产品；
 * @date 2019-01-07
 * 生产模具A
 */
public class MouldProductA extends MouldProduct {
    @Override
    public void show() {
        System.out.println("生产模具A");
    }
}
