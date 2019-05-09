package com.base.designpatterns.behaviortype.interpreterpattern;

/**
 * 抽象表达式
 */
public abstract class Expression {
    /**
     * 解释的操作
     * @param ctx 上下文对象
     * @return
     */
    public abstract void interpreter(Context ctx);
}
