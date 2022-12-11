package com.autohandel;

import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarType;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        System.out.println("Autohandel!");

        Car myCar = new Car();
        System.out.println(myCar);
        myCar.fix("brakes");
        System.out.println(myCar);
    }
}