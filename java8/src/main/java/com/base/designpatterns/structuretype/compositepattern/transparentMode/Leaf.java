package com.base.designpatterns.structuretype.compositepattern.transparentMode;

import java.util.List;

public class Leaf extends Component {

    @Override
    public void add(Component component) {
        //空实现
        System.out.println("添加叶子构件");
    }

    @Override
    public void remove(Component component) {
        //空实现
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }
}
