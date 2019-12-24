package com.base.designpatterns.behaviortype.commandpattern;

/**
 * command类的实现类，对抽象类中声明
 * @author liaowb
 * @date 2019-03-12
 */
public class ConcreteCommand extends Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.doSomething();
    }


}
