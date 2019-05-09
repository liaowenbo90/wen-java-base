package com.base.designpatterns.behaviortype.Iterativesubpattern;

import java.util.ArrayList;
import java.util.List;

public class Mycontainer extends Container {

    private List<Object> list;



    public Mycontainer() {
        this.list = new ArrayList<Object>();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(list);
    }

    @Override
    public void put(Object obj) {
        this.list.add(obj);
    }
}
