package com.extend.test;

/**
 * Created by ksy on 2015/12/24.
 */
public class Parent {
    static {
        System.out.println("parent static");
    }

    public Parent(){
        say();
    }

    private void say(){
        System.out.println("parent say");
    }
}
