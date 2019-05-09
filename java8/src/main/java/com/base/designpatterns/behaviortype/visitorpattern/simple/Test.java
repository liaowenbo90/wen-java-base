package com.base.designpatterns.behaviortype.visitorpattern.simple;

/**
 * 方法method1和方法method2的区别在哪里，方法method1很简单，就是打印出一句“我是A”；方法method2稍微复杂一点，
 * 使用类B作为参数，并调用类B的showA方法。再来看一下类B的showA方法，showA方法使用类A作为参数，然后调用类A的method1方法，
 * 可以看到，method2方法绕来绕去，无非就是调用了一下自己的method1方法而已，
 */
public class Test {

    public static void main (String [] args) {

        A a = new A();
        a.method1();
        a.method2(new B());
    }
}
