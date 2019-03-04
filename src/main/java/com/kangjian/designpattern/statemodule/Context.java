/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.statemodule;

public interface Context {

    void setClock(int hour);

    void changeState(State state);

    void callSecurityCenter(String msg);

    void recordLog(String msg);
}
