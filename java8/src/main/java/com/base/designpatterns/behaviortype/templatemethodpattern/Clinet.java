package com.base.designpatterns.behaviortype.templatemethodpattern;

public class Clinet {

    public static void main (String [] args) {
        ScanBicycle scanBicycle = new ScanBicycle();
            scanBicycle.use();
        CodeBicycle codeBicycle = new CodeBicycle();
            codeBicycle.use();


    }
}
