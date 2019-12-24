package com.base.designpatterns.behaviortype.chainofresponsibilitypattern;

/**
 * 抽象处理者角色代码
 * @author liaowb
 * @date 2019-03-01
 */
public abstract class Handler {

    private Handler nextHander;
    private int level;

    public Handler() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    //抽象方法，子类实现
    public abstract void report(Demand demand);

    // 处理请求传递，注意final,子类不可重写
    public final void handleMessage(Demand demand) {
        if (level == demand.getDemandLevel()) {
            this.report(demand);
        }else{
            if(this.nextHander != null) {
                System.out.println("事情太严重了，需报告上一级");
                this.nextHander.handleMessage(demand);
            }else{
                System.out.println("我就是boss,没有上头");
            }
        }

    }

    public Handler getNextHander() {
        return nextHander;
    }

    public void setNextHander(Handler nextHander) {
        this.nextHander = nextHander;
    }
}
