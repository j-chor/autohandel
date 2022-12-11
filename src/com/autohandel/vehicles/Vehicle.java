package com.autohandel.vehicles;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Vehicle {
    Double value;
    String brand;
    String model;
    Integer mileage;
    String color;
    String classification;
    Boolean brakes;
    Boolean suspension;
    Boolean engine;
    Boolean body;
    Boolean transmission;

    static final String[] colors = {"white", "black", "red", "yellow", "silver", "green"};

    public Boolean getRandomBoolean(Double chance) {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0) > (1.0 - chance);
    }


    public Vehicle() {
        this.mileage = ThreadLocalRandom.current().nextInt(0, 350000);
        this.color = colors[ThreadLocalRandom.current().nextInt(0, colors.length)];
        this.brakes = getRandomBoolean(0.6);
        this.suspension = getRandomBoolean(0.7);
        this.engine = getRandomBoolean(0.9);
        this.body = getRandomBoolean(0.7);
        this.transmission = getRandomBoolean(0.7);

    }

    public void fix(String part) {
        switch (part) {
            case "brakes":
                this.brakes = true;
                this.value *= 1.1;
                break;
            case "suspension":
                this.suspension = true;
                this.value *= 1.2;
                break;
            case "engine":
                this.engine = true;
                this.value *= 2;
                break;
            case "body":
                this.body = true;
                this.value *= 1.5;
                break;
            case "transmission":
                this.transmission = true;
                this.value *= 1.5;
                break;
        }

    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "value=" + value +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", classification='" + classification + '\'' +
                ", brakes=" + brakes +
                ", suspension=" + suspension +
                ", engine=" + engine +
                ", body=" + body +
                ", transmission=" + transmission +
                '}';
    }

    //    public Vehicle(CarType carType, Integer mileage, String color, Boolean brakes, Boolean suspension, Boolean engine, Boolean body, Boolean transmission) {
//        this.value = carType.baseValue;
//        this.brand = carType.brand;
//        this.model = carType.model;
//        this.mileage = mileage;
//        this.color = color;
//        this.classification = carType.classification;
//        this.brakes = brakes;
//        this.suspension = suspension;
//        this.engine = engine;
//        this.body = body;
//        this.transmission = transmission;
//    }
}
