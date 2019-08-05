package com.ieake.day07.demo1;

import java.util.ArrayList;

public class Demo02ArrayList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Boolean result = list.add("jack");
        list.add("bbbb");
        list.add("ccc");

        System.out.println(result);
        System.out.println(list);
        System.out.println(list.get(1));
        String removeName = list.remove(1);
        System.out.println(list);
        System.out.println(removeName);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
