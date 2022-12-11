package com.autohandel.vehicles;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Vehicle {

    private static final CarType[] mazda = {new CarType("Mazda", "RX-7", 65000.0)};
    private static final CarType[] volkswagen = {new CarType("Volkswagen", "Golf", 20000.0),
            new CarType("Volkswagen", "Polo", 9000.0),
            new CarType("Volkswagen", "Passat", 30000.0)};
    private static final CarType[] audi = {new CarType("Audi", "A7", 130000.0)};
    private static final CarType[] skoda = {new CarType("Skoda", "Fabia", 15000.0)};
//    private CarType[] ford;
//    private CarType[] toyota;
//    private CarType[] mercedes;
//    private CarType[] subaru;
//    private CarType[] renault;
//    private CarType[] mitsubishi;
//    private CarType[] fiat;
//    private CarType[] honda;
//    private CarType[] hyundai;
//    private CarType[] ferrari;, ford, toyota, mercedes, fiat, subaru, renault, mitsubishi, fiat, honda, hyundai, ferrari

    private static final CarType[][] brands = {mazda, volkswagen, audi, skoda};

    public Car() {
        super();
        Integer rnd = ThreadLocalRandom.current().nextInt(0, brands.length);
        CarType carType = brands[rnd][ThreadLocalRandom.current().nextInt(0, brands[rnd].length) ];
        this.value = carType.baseValue * ThreadLocalRandom.current().nextDouble(0.9, 1.1) * (this.brakes ? 1d : 0.95d)
                * (this.suspension ? 1d : 0.85d) * (this.engine ? 1d : 0.55d) * (this.body ? 1d : 0.75d) * (this.transmission ? 1d : 0.75d);
        // ^ Uwaga copypaste w każdym rodzaju smaochodu ^
        this.brand = carType.brand;
        this.model = carType.model;
        this.classification = carType.classification;
    }


}
