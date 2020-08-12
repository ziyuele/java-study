package com.kangjian.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Stream01 {

    public static void main(String args[]) {
        List<Widgets> widgetsList = new ArrayList<>();
        widgetsList.add(new Widgets("kangjian", 1));
        widgetsList.add(new Widgets("kangjian", 2));
        widgetsList.add(new Widgets("jiangkan", 3));
        int sum = widgetsList.stream().filter(w -> (w.getAge() > 1)).mapToInt(b -> (b.getAge() + 10)).sum();
        System.out.println(sum);
    }

    @Data
    @AllArgsConstructor
    private static class Widgets {
        String name;
        int age;
    }
}
