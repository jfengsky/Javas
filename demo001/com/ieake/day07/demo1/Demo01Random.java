package com.ieake.day07.demo1;

import java.util.Random;

public class Demo01Random {

    public static void main(String[] args) {

        Random r = new Random();
        int r1 = r.nextInt(10);
        System.out.println(r1);
    }
}
