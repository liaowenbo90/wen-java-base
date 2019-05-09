package com.base.designpatterns.createtype.factorypatten.abstractfactory.product;

/**
 * @date
 * 模具产品B类
 * 步骤4： 创建具体产品类（继承抽象产品类）， 定义生产的具体产品；
 */
public class MouldProductB extends MouldProduct {
    @Override
    public void show() {
        System.out.println("生产模具B");
    }
}
