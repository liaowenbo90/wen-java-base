package com.base.designpatterns.createtype.prototypepattern;

import java.util.ArrayList;

/**
 * @author liaowb
 * @date 2019-01-11
 *    实现一个接口，重写一个方法即完成了原型模式
 *    实现 cloneable 接口,通知虚拟机可以安全实现此类的clone方法
 *    重写Object 类的clone方法,作用是返回一个对象的拷贝
 */
public class Prototype implements Cloneable{
    private ArrayList list = new ArrayList<>();
    @Override
    public Prototype clone(){
        Prototype prototype = null;

        try{
            //浅拷贝
            prototype = (Prototype) super.clone();

            //深拷贝
            prototype.list = (ArrayList) this.list.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

}
