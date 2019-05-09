package com.base.designpatterns.createtype.factorypatten.simplefactory.factory;

import com.base.designpatterns.createtype.factorypatten.simplefactory.product.Product;
import com.base.designpatterns.createtype.factorypatten.simplefactory.product.ProductA;
import com.base.designpatterns.createtype.factorypatten.simplefactory.product.ProductB;

/**
 * 创建工厂类，通过创建静态方法根据传入不同参数从而创建不同具体产品类的实例；
 */
public class Factory {
    /**
     * 生产过程
     *
     * @param productName
     * @return
     */
    public static Product manfactrue(String productName) {
        switch (productName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return null;
        }
    }
}
