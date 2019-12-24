package com.base.designpatterns.structuretype.facadepattern;

/**
 * **3. **客户端调用：爷爷使用智能遥控器的时候
 */
public class FacadePattern {

    public static void main(String [] args ) {
        SubSystemA_light light = new SubSystemA_light();
        SubSystemB_television television = new SubSystemB_television();
        SubSystemC_aircondition aircondition = new SubSystemC_aircondition();
        //传参
        Facade facade = new Facade(light,television,aircondition);
        // 客户端与外观类直接交互
        facade.on();
        System.out.println("可以看电视了");

        facade.off();
        System.out.println("可以睡觉了");
    }
}
