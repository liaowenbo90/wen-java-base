package com.base.designpatterns.behaviortype.visitorpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 结构对象
 * @author liaowb
 * @date 2019-03-12
 */
public class ObjectStruture {

    public static List<Element> getList(){
        List<Element> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(100);
            if(a > 50) {
                list.add(new ConcreteElement1());
            }else {
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}
