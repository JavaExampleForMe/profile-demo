package com.nice.driver;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyClass1 {

    public void main2(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                f1();
            }
        });


    }

    public void f2() {
        Runnable runnable1 = () -> {
            System.out.println("hi");
        };

        Runnable runnable2 = () -> {
            f1();
        };

        Predicate<Integer> p1 = (Integer x) -> x % 2 == 0;
        Predicate<Integer> p2 = (Integer x) -> x % 3 == 0;

        Predicate<Integer> p3 = (Integer x) -> p1.test(x) || p2.test(x) ;
        Predicate<Integer> p4 = (Integer x) -> p1.test(x) && p2.test(x) ;
        Predicate<Integer> p5 = (Integer x) -> p4.test(x) && p1.test(x);

        Comparable<MyClass1> comparable = new Comparable<MyClass1>() {
            @Override
            public int compareTo(MyClass1 o) {
                return 0;
            }
        };

        Runnable runnable3 = this::f1;
        Callable callable = this::f3;
    }

    public void f1() {
        System.out.println("hi");
    }

    public String f3() throws Exception{
        return "hi";
    }
}
