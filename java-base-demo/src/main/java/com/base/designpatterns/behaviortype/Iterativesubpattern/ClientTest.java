package com.base.designpatterns.behaviortype.Iterativesubpattern;

public class ClientTest {

    public static void main (String [] args) {

        //创建一个自定义容器，直接使用ArrayList的实现
        Container strContainer = new Mycontainer();
        strContainer.put("001");
        strContainer.put("002");

        Iterator myiterator = strContainer.iterator();

        //使用迭代器遍历
        System.out.println(myiterator.first());
        while (myiterator.hasNext()) {
            System.out.println(myiterator.next());
        }







    }


}
