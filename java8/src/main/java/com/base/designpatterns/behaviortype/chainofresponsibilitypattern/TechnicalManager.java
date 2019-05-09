package com.base.designpatterns.behaviortype.chainofresponsibilitypattern;

/**
 * 技术经理，具体处理者
 *
 */
public class TechnicalManager extends Handler {

    public TechnicalManager(){
        super();
    }


    @Override
    public void report(Demand demand) {
        System.out.println("需求:" + demand.getDetail());
        System.out.println(getClass().getSimpleName() + "小猿我挺你，这个需求不干") ;
    }




}
