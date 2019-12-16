package com.base.designpatterns.createtype.factorypatten.factoryMothed.factory;

import com.base.designpatterns.createtype.factorypatten.simplefactory.product.ProductB;

public class FactoryB extends Factory {
    @Override
    public ProductB mamufacture() {
        return new ProductB();
    }
}
