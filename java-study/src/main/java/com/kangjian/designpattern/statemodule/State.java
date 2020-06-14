/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.statemodule;

public interface State {
    void doCheck(Context context, int hour);

    void doUse(Context context);

    void doAlarm(Context context);

    void doPhone(Context context);
}
