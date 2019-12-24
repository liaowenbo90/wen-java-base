package com.base.designpatterns.createtype.factorypatten.abstractfactory.factory;

import com.base.designpatterns.createtype.factorypatten.simplefactory.product.Product;

/**
 * @author liaowb
 * @date 2019-01-07
 * 步骤1： 创建抽象工厂类，定义具体工厂的公共接口
 */
public abstract class Factory {
    /**
     * 制造容器
     * @return
     */
    public abstract Product manufactrueContainer();

    /**
     * 制造模具
     * @return
     */
    public abstract Product manufactrueMould();
}
