package com.base.designpatterns.structuretype.adapterpattern;

/**
 * @author lwb
 * 步骤4：定义具体使用目标类，并通过Adapter类调用所需要的方法从而实现目标
 */
public class AdapterPattern {

    public static void main(String[] agrs) {
        Target target = new Adapter();

        target.request();

    }
}
