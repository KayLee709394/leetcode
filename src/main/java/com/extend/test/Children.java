package com.extend.test;

/**
 * Created by ksy on 2015/12/24.
 */
public class Children extends Parent {
    static {
        System.out.println("children static");
    }

    public Children(){
        say();
    }

    private void say(){
        System.out.println("children say");
    }

    public static void main(String[] arg){
        Parent p = new Children();
        Children c = new Children();
    }
}
