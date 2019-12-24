package com.base.designpatterns.behaviortype.mementopattern;

/**
 *  代码演示了一个单状态单备份的例子，逻辑非常简单：Originator类中的state变量需要备份，
 *  以便在需要的时候恢复；Memento类中，也有一个state变量，用来存储Originator类中state变量的临时状态；
 *  而Caretaker类就是用来管理备忘录类的，用来向备忘录对象中写入状态或者取回状态。
 * ---------------------
 */
public class Client {

    public static void main(String [] args) {
        Originator originator = new Originator();
        originator.setState("状态1");
        System.out.println("初始状态：" + originator.getState());
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("状态2");
        System.out.println("改变状态：" + originator.getState());
        originator.restorememento(caretaker.getMemento());
        System.out.println("恢复后状态：" + originator.getState());


    }
}
