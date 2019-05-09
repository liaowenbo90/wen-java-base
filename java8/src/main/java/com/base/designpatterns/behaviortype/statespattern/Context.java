package com.base.designpatterns.behaviortype.statespattern;

/**
 * 环境角色
 * @author liaowb
 * @date 2019-03-13
 *
 * 环境类Context的行为request()是委派给某一个具体状态类的。通过使用多态性原则，可以动态改变环境类Context的属性State的内容，
 * 使其从指向一个具体状态类变换到指向另一个具体状态类，从而使环境类的行为request()由不同的具体状态类来执行。
 *
 */
public class Context {

    //持有一个state类型的对象实例
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 用户感兴趣的接口方法
     * @param sampleParameter
     */
    public void request(String sampleParameter){
        //转调sate来处理
        state.handle(sampleParameter);

    }
}
