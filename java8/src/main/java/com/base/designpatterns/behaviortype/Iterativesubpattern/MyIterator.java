package com.base.designpatterns.behaviortype.Iterativesubpattern;

import java.util.List;

/**
 * @author liaowb
 * 具体实现迭代器，实现上述接口定义的方法
 * @date 2019-02-21
 */
public class MyIterator implements Iterator{

    private List<Object> list;
    private int index = 0;

    public MyIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        if(this.list.size() <= 0) {
            return null;
        }else{
            return this.list.get(0);
        }
    }

    @Override
    public Object previous() {
        if((this.index - 1) < 0) {
            return null;
        }else{
            return this.list.get(--index);
        }
    }

    @Override
    public Object next() {
        if((this.index + 1) >= this.list.size()){
            return null;
        }else{
            return this.list.get(++index);
        }
    }

    @Override
    public boolean hasNext() {
        if(this.index < (this.list.size() - 1)) {
            return true;
        }
        return false;
    }
}
