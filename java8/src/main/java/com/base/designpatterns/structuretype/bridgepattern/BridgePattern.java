package com.base.designpatterns.structuretype.bridgepattern;

/**
 * 5 测试代码
 */
public class BridgePattern {

    public  static  void  main (String [] args) {
        //（加入有个外国人来到中国，比如去了上海要吃红烧肉，正好他去了小南国，这时候他要评价了）
        Restaurant rest = new XiaoNanGuo();
        AbstractCityArea sr = new ShanghaiRestaurant(rest);
        sr.commentTaste();
        //（有一天他又来到南京，去外婆家去吃红烧肉，吃完又要评价了）
        Restaurant rest2 = new Waipojia();
        AbstractCityArea sr2 = new NanjingRestaurant(rest2);
        sr2.commentTaste();
    }



}
