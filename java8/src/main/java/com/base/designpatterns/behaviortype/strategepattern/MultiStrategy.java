package com.base.designpatterns.behaviortype.strategepattern;

/**
 * 乘法的具体实现策略
 */
public class MultiStrategy implements Strategy {

    @Override
    public double calc(double paramA, double paramB) {
        return paramA * paramB;
    }
}
