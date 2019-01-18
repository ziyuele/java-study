package com.kangjian.tmp;

public class Tmp5 {
    public static void main(String args[]){
        int x = Integer.MAX_VALUE;
        int a = x + 10;
        int b = x + 11;

        System.out.println(new Tests().getaBoolean());
    }
}


class Tests{
   private Boolean aBoolean;
   public Boolean getaBoolean(){
       return aBoolean;
   }
}