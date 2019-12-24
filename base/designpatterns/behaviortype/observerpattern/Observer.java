package com.base.designpatterns.behaviortype.observerpattern;

/**
 * @author liaowb
 * 被观察者
 * 观察者模式这种发布-订阅的形式我们可以拿微信公众号来举例，假设微信用户就是观察者，
 * 微信公众号是被观察者，有多个的微信用户关注了程序猿这个公众号，当这个公众号更新时
 * 就会通知这些订阅的微信用户。好了我们来看看用代码如何实现：
 */
public interface Observer {
    /**
     * 更变
     */
    void update(String message);

}
