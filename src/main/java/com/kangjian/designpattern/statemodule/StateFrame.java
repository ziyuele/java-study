/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.statemodule;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StateFrame extends Frame implements Context, ActionListener {

    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("使用金库");
    private Button buttonAlarm = new Button("按下警铃");
    private Button buttonPhone = new Button("正常通话");
    private Button buttonExist = new Button("结束");

    private State state = DayState.getInstance();

    public StateFrame(String title) {
       super(title);
       setBackground(Color.lightGray);
       setLayout(new BorderLayout());
       // textClock
       add(textClock, BorderLayout.NORTH);
       textClock.setEditable(false);

       // textScreen
       add(textScreen, BorderLayout.CENTER);
       textScreen.setEditable(false);

       // add button
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExist);

        add(panel);

        pack();
        show();

        buttonUse.addActionListener(this);
        buttonExist.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonAlarm.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {
            state.doUse(this);
        } else  if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);
        } else if(e.getSource() == buttonExist) {
            System.exit(0);
        } else {
            System.err.println("?");
        }
    }

    @Override
    public void setClock(int hour) {
        String clockingString = "现在时间是";

        if (hour < 10) {
            clockingString += "0" + hour + ":00";
        } else {
            clockingString += hour + ":00";
        }
        System.out.println(clockingString);
        textScreen.setText(clockingString);
        state.doCheck(this, hour);
    }

    @Override
    public void changeState(State state) {

        System.out.println("stat changed from " + this.state + " to " + state + "status") ;
        this.state  = state;
    }

    @Override
    public void callSecurityCenter(String msg) {

        textScreen.append("call " + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {

        textScreen.append("recoding ..." + msg + "\n");
    }
}
