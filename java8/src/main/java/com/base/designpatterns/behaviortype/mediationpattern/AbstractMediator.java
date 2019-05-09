package com.base.designpatterns.behaviortype.mediationpattern;

public abstract class AbstractMediator {

    protected  AbstractConlleague A;
    protected  AbstractConlleague B;

    public AbstractMediator(AbstractConlleague a, AbstractConlleague b) {
        A = a;
        B = b;
    }

    public abstract  void AaffectB();
    public abstract  void BaffectA();

}
