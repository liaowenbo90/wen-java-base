package com.base.designpatterns.createtype.prototypepattern;

public class Client {

    public static void main (String[] args) {
        ConcreatePrototype cp = new ConcreatePrototype();
        for (int i = 0; i <10 ; i++) {
            ConcreatePrototype clone = (ConcreatePrototype) cp.clone();
            clone.show();
        }
    }
}
