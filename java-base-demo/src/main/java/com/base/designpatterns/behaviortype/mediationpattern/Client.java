package com.base.designpatterns.behaviortype.mediationpattern;

/**
 * 其实就是把原来处理对象关系的代码重新封装到一个中介类中，通过这个中介类来处理对象间的关系。
 */
public class Client {

    public static void main(String[] args) {
//        AbstractConlleague abstractConlleagueA = new ColleagueA();
//        AbstractConlleague abstractConlleagueB = new ColleagueB();
//
//        System.out.println("=====设置A影响B=-==");
//        abstractConlleagueA.setNumber(1288,abstractConlleagueB);
//        System.out.println("collA的number值：" + abstractConlleagueA.getNumber());
//        System.out.println("collB的number值：" + abstractConlleagueB.getNumber());
//
//        System.out.println("==========设置B影响A==========");
//
//        abstractConlleagueB.setNumber(87635,abstractConlleagueA);
//        System.out.println("collB的number值：" + abstractConlleagueB.getNumber());
//        System.out.println("collA的number值：" + abstractConlleagueA.getNumber());


        AbstractConlleague abstractConlleagueA = new ColleagueA();
        AbstractConlleague abstractConlleagueB = new ColleagueB();

        AbstractMediator abstractMediator = new Mediator(abstractConlleagueA, abstractConlleagueB);

        System.out.println("通过设置A影响B========");
        abstractConlleagueA.setNumber(1000, abstractMediator);
        System.out.println("collA的number值：" + abstractConlleagueA.getNumber());
        System.out.println("collb的number值为A的10倍：" + abstractConlleagueA.getNumber());

        System.out.println("通过设置B影响A========");
        abstractConlleagueB.setNumber(1000,abstractMediator);
        System.out.println("collB的number值：" + abstractConlleagueB.getNumber());
        System.out.println("collA的number值为B的0.1倍：" + abstractConlleagueA.getNumber());
    }
}
