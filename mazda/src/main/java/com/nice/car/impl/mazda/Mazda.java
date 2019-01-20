package com.nice.car.impl.mazda;

import com.nice.car.Car;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Lazy
@Component
//@Profile("mazda")
public class Mazda implements Car {
    public Mazda() {
        System.out.println("initialize mazda");
    }

    @Override
    public void drive() {
        System.out.println("Im driving in mazda");
    }
}
