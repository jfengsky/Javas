package com.ieake.day09.demo03;

public class DemoInterface {

    public static void main(String[] args) {

        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();

        impl.methodAbs();
        impl.methodAbs2();
        MyInterfaceAbstract.methodAbs4();
    }
}
