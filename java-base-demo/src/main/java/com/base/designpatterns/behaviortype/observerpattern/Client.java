package com.base.designpatterns.behaviortype.observerpattern;

public class Client {

    public static void main(String [] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        // 创建微信用户
        WeixinUser user1 = new WeixinUser("AA用户");
        WeixinUser user2 = new WeixinUser("BB用户");
        WeixinUser user3 = new WeixinUser("CC用户");

        //订阅公众号
        subscriptionSubject.attach(user1);
        subscriptionSubject.attach(user2);
        subscriptionSubject.attach(user3);

        subscriptionSubject.notify("DD用户的专栏更新了");



    }
}
