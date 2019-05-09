package com.base.designpatterns.createtype.buliderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowb
 * 组装电脑
 * @date 2019-01-10
 */
public class Computer {

    //电脑组件的集合
    private List<String> parts = new ArrayList<>();

    // 用于组件组装到电脑里
    public void add(String part) {
        parts.add(part);
    }

    public void show(){
        for(int i=0; i<parts.size(); i++) {
            System.out.println("组件"+ parts.get(i)+"装好了");
        }
        System.out.println("电脑组装完成，请验收");
    }
}
