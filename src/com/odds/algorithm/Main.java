package com.odds.algorithm;

public class Main {
    static long start;
    static long end;

    public static void main(String[] args) {
        start = System.currentTimeMillis();

        test1();

        end = System.currentTimeMillis();

        System.out.println("执行时间：" + (end - start)/1000);
    }

    //多项式：f(x)= 1 + 1*x + 2*x^2 + 3*x^3...
    public static void test1(){

    }
}
