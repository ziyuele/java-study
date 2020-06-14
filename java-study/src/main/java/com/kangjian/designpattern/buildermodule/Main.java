/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.designpattern.buildermodule;

public class Main {

    public static void main(String args[]) {

        System.out.println("making text builder");


        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("making html builder");

        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Director director1 = new Director(htmlBuilder);
        director1.construct();
        String fileName = htmlBuilder.getResult();
        System.out.println(fileName + "文档编写完成");

    }
}
