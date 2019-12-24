package com.base.designpatterns.behaviortype.strategepattern;

/**
 * @author liaowb
 * 进行计算操作的上下文环境
 */
public class Calc {

    private Strategy mstrategy;

    public Calc(){};

    public Calc(Strategy mstrategy) {
        this.mstrategy = mstrategy;
    }

    public double calc(double parmA,double paramB) {

        if(mstrategy == null) {
            throw new IllegalStateException("You haven't set the strategy for computing");
        }
        return  mstrategy.calc(parmA,paramB);
    }


}
