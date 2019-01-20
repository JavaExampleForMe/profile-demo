package com.nice.driver;

import com.nice.car.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan({"com.nice.car.impl"})
public class DriverApplication {


    //------------------- 8 --------------------
    static AtomicInteger count;
    //---------------------------------5-------------------
    Predicate<Integer> p1 = (Integer number) -> number % 2 == 0;
    Predicate<Integer> p2 = (Integer number) -> number % 3 == 0;

    static <T> int identity(T a) {
     return 3;
    }

    public static void main(String[] args) {

        List<Integer> list13=new ArrayList<>();

// list1 is used only after the following code is done.
// your oo-worker says that this pipeline has no
// reason/can't to run for some reason in parallel.
        Stream.of(1,2,3,4,5)
                .filter(x->x>3)
                .parallel()
                .peek(x-> System.out.println(x))
                .sorted()
                .forEach(x-> list13.add(x));

        //------------------- 10 --------------------
        List<Integer> l6 = Arrays.asList(1,1,2,2);

        Arrays.asList(l6,l6,l6).stream()
        .flatMap(list1 -> list1.stream())
            .mapToInt(x -> identity(x))
            .forEach(System.out::println);
        /////---------------------------------------------
        List<Integer> l11 = Arrays.asList(1,2,3,4,5);

        int sum1 = Arrays.asList(l11,l11,l11)
                .stream()
                .flatMap(list1 -> list1.stream()
                        .map((Integer x) -> x * 10)
                        .peek(System.out::println)
                )
                .mapToInt(x->x)
                .sum();

        // ------------------------------
        Stream<Integer> stream1 = Stream.of(1, 2)
                .peek((Integer number) -> System.out.println(number));

        Stream<Integer> stream2 = Stream.of(1, 2)
                .peek((Integer number) -> System.out.println(number));

        stream1.flatMap(number -> Stream.of(1, 2)
                .peek((Integer number1) -> System.out.println(number1))
                .filter(x -> x != number))
                .forEach((Integer number) -> System.out.println(number));

        //----------------------
        final ConfigurableApplicationContext context = SpringApplication.run(DriverApplication.class, args);
        System.out.println("-------------------------------------");
        Car car = context.getBean(Car.class);
        car.drive();

        Function<String, Integer> f1 = (String x) -> x.length();
        Integer[] x = f1.andThen((Integer number) -> new Integer[number])
                .apply("123");
        System.out.println(x[0]);

        // ----------------  5  ----------------------
        Predicate<Integer> p1 = (Integer number) -> number % 2 == 0;
        Predicate<Integer> p2 = (Integer number) -> number % 3 == 0;

        Stream.of(1, 2, 3)
                .peek((Integer number) -> System.out.println(number))
                .filter(p1.or(p2)) // <<<----- or
                .forEach((Integer number) -> System.out.println(number));

        //-------------- 1 ----------
        Stream.of(1, 2, 3)
                .map((Integer number) -> number * 10)
                .findFirst()
                .ifPresent((Integer number) -> System.out.println(number));
        // ---------------7 -------------------------
        Stream<Integer> stream4 = Stream.of(100, 200)
                .peek((Integer number) -> System.out.println(number));

        final Stream<Integer> integerStream = Stream.of(1, 10, 100, 1000);

        integerStream.findFirst()
                .map((Integer number) -> number * 10)
                .ifPresent((Integer number) -> System.out.println(number));

        integerStream.findFirst()
                .map((Integer number) -> number * 10)
                .ifPresent((Integer number) -> System.out.println(number));
    }

    public static void f1() {
        count.set(1);
        for (int i = 1; i <= 10; i++)
            new Thread(() -> count.addAndGet(1)).start();
    }
}
