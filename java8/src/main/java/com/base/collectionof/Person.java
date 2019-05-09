package com.base.collectionof;

import java.util.Set;
import java.util.TreeMap;

public class Person implements Comparable<Person>{

    private String name; private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * TODO重写compareTo方法实现按年龄来排序
     */
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        }
        return age;
    }

//    @Override
//    public int compareTo(Object o) {
//        // TODO Auto-generated method stub
//        if (this.age > o.getAge()) {
//            return 1;
//        } else if (this.age < o.getAge()) {
//            return -1;
//        }
//        return age;
//    }
}
