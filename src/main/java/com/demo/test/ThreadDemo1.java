package com.demo.test;

import java.util.Date;
import java.util.Random;

/**
 * 创建人是: zsg 创建时间: 2018/5/18 0018.
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("ThreadA");
        a.start();

        Runnable r = new ThreadB();
        Thread b = new Thread(r);
        b.setName("ThreadB");
        b.start();

        while ( handle()){
            System.out.println("######");
        }
    }

    public static boolean handle(){
        for(int i=0;i<20000000;i++){
            double v = new Random().nextDouble() * i;
        }
        return true;
    }
}

class ThreadA extends Thread{
    public Long l = new Date().getTime();
    @Override
    public void run() {
        while ( handle()){
            System.out.println(this.getName() + " >>>>>" + (new Date().getTime()-l));
        }
    }
    public boolean handle(){
        for(int i=0;i<10000000;i++){
            double v = new Random().nextDouble() * i;
        }
        return true;
    }
}

class ThreadB implements Runnable{
    public Long l = new Date().getTime();
    @Override
    public void run() {
        while ( handle()){
            System.out.println("&&&&&&&" + (new Date().getTime()-l));
        }
    }
    public boolean handle(){
        for(int i=0;i<10000000;i++){
            double v = new Random().nextDouble() * i;
        }
        return true;
    }
}

