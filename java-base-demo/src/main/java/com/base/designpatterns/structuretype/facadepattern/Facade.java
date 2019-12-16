package com.base.designpatterns.structuretype.facadepattern;

/**
 * @author liaowb
 * 外观类
 */
public class Facade {
    SubSystemA_light subSystemA_light;
    SubSystemB_television subSystemB_television;
    SubSystemC_aircondition subSystemC_aircondition;

    public Facade(SubSystemA_light subSystemA_light, SubSystemB_television subSystemB_television, SubSystemC_aircondition subSystemC_aircondition) {
        this.subSystemA_light = subSystemA_light;
        this.subSystemB_television = subSystemB_television;
        this.subSystemC_aircondition = subSystemC_aircondition;
    }
    //起床后开电器
    public void on() {
        System.out.println("起床了");
        subSystemA_light.on();
        subSystemB_television.on();
        subSystemC_aircondition.on();
    }

    public void off(){
        System.out.println("睡觉了");
        subSystemA_light.off();
        subSystemB_television.off();
        subSystemC_aircondition.off();
    }


}
