package com.ieake.day07.demo1;

import java.util.ArrayList;

public class Demo04ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("jack");
        list.add("tom");
        list.add("terry");


        System.out.println(list);
        printArrayList(list);
    }

    public static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if(i == list.size() - 1){
                System.out.print(name + "}");
            } else {
                System.out.print(name + "@");
            }
        }

    }
}
