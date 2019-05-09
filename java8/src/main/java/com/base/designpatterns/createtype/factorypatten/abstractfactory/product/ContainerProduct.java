package com.base.designpatterns.createtype.factorypatten.abstractfactory.product;

import com.base.designpatterns.createtype.factorypatten.simplefactory.product.Product;

/**
 * 步骤3： 创建抽象产品类 ，定义具体产品的公共接口；
 * @date 2019-01-07
 * 容器产品抽象类
 */
public abstract class ContainerProduct extends Product {


    @Override
    public abstract void show();
}
