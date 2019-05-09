package com.base.designpatterns.behaviortype.strategepattern;

/**
 * 减法的具体实现策略
 */
public class SubStrategy implements Strategy {

    @Override
    public double calc(double paramA, double paramB) {
        return paramA - paramB;
    }

}
