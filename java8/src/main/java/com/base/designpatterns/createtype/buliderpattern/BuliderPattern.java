package com.base.designpatterns.createtype.buliderpattern;

/**
 * @author liaowb
 * **步骤5： **客户端调用-小成到电脑城找老板买电脑
 * @date 2019-01-10
 */
public class BuliderPattern {

    public static void main(String[] agrs) {

        //找到老板和装机人员
        Director director = new Director();
        Builder builder = new ConcreateBuilder();

        // 老板叫 装机人员装机
        director.construct(builder);

        //装完后，组装人员搬来组装好的电脑
        Computer computer = builder.getComputer();
        //展示装好的组件
        computer.show();
    }
}
