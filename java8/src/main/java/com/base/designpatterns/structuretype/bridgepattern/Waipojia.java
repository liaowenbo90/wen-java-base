package com.base.designpatterns.structuretype.bridgepattern;

/**
 * @author liaowb
 * 2 ConcreteImplementor（具体的餐馆：小南国和外婆家）
 */
public class Waipojia implements Restaurant{

    @Override
    public String taste() {
        return "红烧肉味道一般";
    }
}
