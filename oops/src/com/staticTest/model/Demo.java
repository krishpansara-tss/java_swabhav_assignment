package com.staticTest.model;

public class Demo {
    private int a;
    private static int b;


    public Demo(){
        System.out.println("Constructor");
        a = 0;
        b = 0;
    }

    public void increment(){
        a++;
        b++;
    }

    public void show(){
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
    }

    static {
        System.out.println("hello");
    }

    {
//        b = 10;
        System.out.println("blah blah ");
    }

}
