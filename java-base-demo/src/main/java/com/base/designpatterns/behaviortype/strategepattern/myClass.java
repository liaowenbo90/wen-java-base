package com.base.designpatterns.behaviortype.strategepattern;

/**
 * @author liaowb
 * @date 2019-01-22
 * 测试类
 */
public class myClass {
    public double calc(Strategy strategy,double paramA,double paramB) {

        Calc calc = new Calc(strategy);
        return  calc.calc(paramA,paramB);

    }

    public static void main(String [] args) {

        myClass myClass = new myClass();

        System.out.println("addStrategy:" + myClass.calc(new AddStrategy(),5,10));
        System.out.println("SubStrategy:" + myClass.calc(new SubStrategy(),5,10));
        System.out.println("MultiStrategy:" + myClass.calc(new MultiStrategy(),5,10));
        System.out.println("DivStrategy:" + myClass.calc(new DivStrategy(),5,10));

    }



}
