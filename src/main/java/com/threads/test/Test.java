package com.threads.test;

/**
 * Created by ksy on 2015/12/24.
 */
public class Test{
    public static void main(String args[]){
        Num num = new Num(0);
        Thread thOdd = new Thread(new ThOdd(num));
        Thread thEdd = new Thread(new ThEdd(num));
        thOdd.setName("odd");
        thEdd.setName("edd");
        thOdd.start();
        thEdd.start();
    }
}
class Num {
    public int num = 0;
    public Num(int num){
        this.num = num ;
    }
    public synchronized void printOdd(){
        System.out.println(Thread.currentThread().getName()+"------->"+(num++));
        try{
            this.notifyAll();
            this.wait();
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public synchronized void printEdd(){
        System.out.println(Thread.currentThread().getName()+(num++));
        try{
            this.notifyAll();
            this.wait();
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class ThOdd implements Runnable{
    private Num num ;
    public ThOdd(Num num){
        this.num = num ;
    }
    public void run(){
        while(true){
            num.printOdd();
        }
    }
}
class ThEdd implements Runnable{
    private Num num ;
    public ThEdd(Num num){
        this.num = num ;
    }
    public void run(){
        while(true){
            num.printEdd();
        }
    }
}
