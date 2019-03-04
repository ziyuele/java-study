/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.statemodule;

public class NightState implements State{

    private static NightState nightState = new NightState();

    public static NightState getInstance() {
        return nightState;
    }

    @Override
    public void doCheck(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter(" night using ! warn");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("alarming night! warn");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("night");
    }

    @Override
    public String toString() {
        return "night";
    }
}
