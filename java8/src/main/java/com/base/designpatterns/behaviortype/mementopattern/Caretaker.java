package com.base.designpatterns.behaviortype.mementopattern;

/**
 * 管理角色
 * @author liaowb
 * @date 2019-03-12
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }


}
