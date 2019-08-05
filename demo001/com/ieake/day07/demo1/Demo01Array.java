package com.ieake.day07.demo1;

public class Demo01Array {

    public static void main(String[] args) {

        Person[] array = new Person[3];
        Person one = new Person("tom", 18);
        Person two = new Person("jack", 28);
        Person three = new Person("white", 38);

        array[0] = one;
        array[1] = two;
        array[2] = three;

        System.out.println(array[1].getName());


    }
}
