package com.base.designpatterns.behaviortype.mediationpattern;

public class ColleagueA extends AbstractConlleague {

    @Override
    public void setNumber(int number, AbstractMediator abstractMediator) {
        this.number = number;
        abstractMediator.BaffectA();
    }
}
