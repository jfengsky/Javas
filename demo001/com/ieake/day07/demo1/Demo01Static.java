package com.ieake.day07.demo1;

public class Demo01Static {

    int num;
    static int numStatic;

    static {

    }

    public static void main(String[] args) {
        myMethod();
    }

    public void method(){
        System.out.println(num);
        System.out.println(numStatic);

    }

    public static void myMethod() {
        System.out.println("自己的方法");

        System.out.println(numStatic);

    }


}
