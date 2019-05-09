package com.base.designpatterns.behaviortype.chainofresponsibilitypattern;

public class Demand {

    private int demandLevel;

    private String detail;

    public int getDemandLevel() {
        return demandLevel;
    }

    public void setDemandLevel(int demandLevel) {
        this.demandLevel = demandLevel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
