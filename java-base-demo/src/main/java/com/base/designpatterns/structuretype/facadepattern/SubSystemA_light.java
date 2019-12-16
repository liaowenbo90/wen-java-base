package com.base.designpatterns.structuretype.facadepattern;

/**
 * @author liaowb
 * @date 2019-01-14
 * 灯类
 *
 */
public class SubSystemA_light {
    public void on(){
        System.out.println("打开了灯");
    }
    public void off(){
        System.out.println("关闭了灯");
    }
}
