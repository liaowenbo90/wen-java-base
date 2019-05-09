package com.base.designpatterns.createtype.factorypatten.abstractfactory.product;

/**
 * 步骤4： 创建具体产品类（继承抽象产品类）， 定义生产的具体产品；
 * 容器产品B
 */
public class ContainerProductB extends ContainerProduct {
    @Override
    public void show() {
        System.out.println("生产了容器产品B");
    }
}
