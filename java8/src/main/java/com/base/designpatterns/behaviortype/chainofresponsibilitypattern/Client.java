package com.base.designpatterns.behaviortype.chainofresponsibilitypattern;

public class Client {

    public static void main(String [] args) {

        Demand demandA = new Demand();
        demandA.setDemandLevel(1);
        demandA.setDetail("加一张露一点点的图A");
        Demand demandB = new Demand();
        demandA.setDemandLevel(2);
        demandA.setDetail("加一张露一点点的图B");

        Boss boss = new Boss();
        boss.setLevel(1);
        TechnicalManager technicalManager = new TechnicalManager();
        technicalManager.setLevel(2);
        //设置下一级
        technicalManager.setNextHander(boss);

        technicalManager.handleMessage(demandA);
        System.out.println("====================");
        technicalManager.handleMessage(demandB);

    }
}
