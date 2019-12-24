package com.base.designpatterns.createtype.buliderpattern;

/**
 * @author liaowb
 * 步骤2： 电脑城老板委派任务给装机人员（Director）
 * @date 2019-01-*10
 *
 */
public class Director {

    /**
     *  指挥装机人员组装电脑
     */
    public void construct(Builder builder) {
        builder.buildeCpu();
        builder.buildHD();
        builder.buildeMianboard();
    }

}
