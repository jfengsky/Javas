package com.ieake.day07.demo1;

public class Demo06String {
    public static void main(String[] args) {
        /*
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);

        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        String str3 = "How do you do";
        String str4 = str3.replace("o","*");
        System.out.println(str4);
         */

        String str1 = "aaa,bbb,cccc";
        String[] split = str1.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

    }
}
