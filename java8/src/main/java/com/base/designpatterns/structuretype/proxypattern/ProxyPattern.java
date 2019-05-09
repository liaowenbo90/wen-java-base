package com.base.designpatterns.structuretype.proxypattern;

/**
 * @author liaowb
 * @date 2019-01-14
 * 代理调用
 */
public class ProxyPattern {

    public static void main (String [] args) {

        Subject subject =  new Proxy();
        subject.buyMac();

    }
}
