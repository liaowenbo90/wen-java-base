package com.base.designpatterns.createtype.buliderpattern;

/**
 * @author liaowb
 * **步骤3： **创建具体的建造者（ConcreteBuilder）:装机人员
 * 装机人员1
 * @date 2019-01-10
 */
public class ConcreateBuilder extends Builder {

    Computer computer = new Computer();

    @Override
    public void buildeCpu() {
        computer.add("组装cpu");
    }

    @Override
    public void buildeMianboard() {
        computer.add("组装主板");
    }

    @Override
    public void buildHD() {
        computer.add("组装硬盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
