package com.base.designpatterns.createtype.buliderpattern;

/**
 * @author liaowb
 * @date 2019-01-10
 * 1定义组装过程（Builder）:组装电脑的过程
 */
public abstract class Builder {

    //声明抽象方法，具体由子类实现
    // 1装cpu
    public abstract void buildeCpu();

    //2、装主板
    public abstract void buildeMianboard();

    //3、装硬盘
    public abstract void buildHD();

    //返回产品的方法，获得组装好的电脑
    public abstract Computer getComputer();

}