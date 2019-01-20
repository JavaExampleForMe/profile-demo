package com.nice.car.impl.fiat;

import com.nice.car.Car;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
//@Profile("fiat")
public class Fiat implements Car {
    @Override
    public void drive() {

        System.out.println("Im driving in Fiat!!!");
    }
}
