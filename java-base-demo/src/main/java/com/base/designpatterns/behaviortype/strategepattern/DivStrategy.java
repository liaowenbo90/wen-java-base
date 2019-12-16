package com.base.designpatterns.behaviortype.strategepattern;

/**
 * 除法的具体实现策略
 */
public class DivStrategy implements Strategy {

    @Override
    public double calc(double paramA, double paramB) {
        return paramA / paramB;
    }
}
