package com.base.designpatterns.behaviortype.chainofresponsibilitypattern;

/**
 * boss
 */
public class Boss extends Handler {

    public Boss(){
        super();
    }

    @Override
    public void report(Demand demand) {
       System.out.println("需求：" + demand.getDetail());

       System.out.println(getClass().getSimpleName() + ":你们打一架吧，打赢的做决定");


    }
}
