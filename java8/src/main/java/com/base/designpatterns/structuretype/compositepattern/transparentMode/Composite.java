package com.base.designpatterns.structuretype.compositepattern.transparentMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowb
 * @date 2019-01-15
 * 2 树枝构件
 */
public class Composite extends Component {
    //构件容器
    private ArrayList<Component> componentArrayList = new ArrayList<>();

    //增加一个叶子构件或者树枝构件
    @Override
    public void add(Component component) {
        this.componentArrayList.add(component);
    }
    //删除一个叶子构件或树枝构件
    @Override
    public void remove(Component component) {
        this.componentArrayList.remove(component);
    }
    //获得分支下的所有构件和树枝构件
    @Override
    public List<Component> getChildren() {
        return this.componentArrayList;

    }
}
