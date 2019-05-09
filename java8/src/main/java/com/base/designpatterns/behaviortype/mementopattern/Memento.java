package com.base.designpatterns.behaviortype.mementopattern;

/**
 * 备忘录
 * @author liaowb
 * @date 2019-03-12
 */
public class Memento {

    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
