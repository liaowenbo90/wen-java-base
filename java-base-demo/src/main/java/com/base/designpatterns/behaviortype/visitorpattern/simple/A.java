package com.base.designpatterns.behaviortype.visitorpattern.simple;

public class A {
    public void method1(){
        System.out.println("我是A");
    }
    public void method2(B b) {
        b.showA(this);
    }
}
