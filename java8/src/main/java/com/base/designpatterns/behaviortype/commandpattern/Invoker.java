package com.base.designpatterns.behaviortype.commandpattern;

/**
 * 调用者 负责调用命令
 * @author liaowb
 * @date 2019-03-12
 *
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }


}
