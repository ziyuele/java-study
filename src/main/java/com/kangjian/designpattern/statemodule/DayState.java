/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.statemodule;

public class DayState implements State{

    private static DayState dayState = new DayState();

    public static DayState getInstance() {
        return dayState;
    }

    @Override
    public void doCheck(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("using day");

    }

    @Override
    public void doAlarm(Context context) {

        context.callSecurityCenter("do alarming day");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("phone day");
    }

    @Override
    public String toString() {
        return "day";
    }
}
