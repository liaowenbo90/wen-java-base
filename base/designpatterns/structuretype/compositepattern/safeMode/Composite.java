package com.base.designpatterns.structuretype.compositepattern.safeMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowb
 * @date 2019-01-15
 * ②树枝构件
 */
public class Composite extends Component {

    //构件容器
    private List<Component> componentList = new ArrayList<Component>();
    // 增加一个叶子构件或树枝构件
    public void add(Component component) {
        this.componentList.add(component);
    }
    //删除一个叶子构件或树枝构件
    public void remove(Component component) {
        this.componentList.remove(component);
    }
    //得到所有叶子构件和树枝构件
    public List<Component> getChildren() {
        return this.componentList;
    }

}
