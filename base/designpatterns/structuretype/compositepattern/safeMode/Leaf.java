package com.base.designpatterns.structuretype.compositepattern.safeMode;

/**
 * @author liaowb
 * @date 2019-01-15
 *
 * 3 树叶构件
 */
public class Leaf extends Component {

    @Override
    public void operation() {
        super.operation();
        System.out.println("重写了父类方法");
    }


}
