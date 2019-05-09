package com.base.designpatterns.behaviortype.mementopattern;

/**
 * 发起人
 * @author liaowb
 * @date 2019-03-12
 */
public class Originator {

    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(this.state);
    }
    public void restorememento(Memento memento) {
        this.setState(memento.getState());
    }
}
