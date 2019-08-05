package com.ieake.day09.demo03;

public interface MyInterfaceAbstract {

    public static final int num = 10;

    public abstract void methodAbs();
    void methodAbs2();

    public default void methodAbs3() {

    }

    private void methodDef(){

    }

    private static void methodDef2(){

    }

    public static void methodAbs4(){

    }
}
