package com.ieake.day07.demo1;

import java.util.Scanner;

public class Demo01Scranner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("first number");
        int a = sc.nextInt();
        System.out.println("second number");
        int b = sc.nextInt();

        System.out.println(a + b);
    }
}
