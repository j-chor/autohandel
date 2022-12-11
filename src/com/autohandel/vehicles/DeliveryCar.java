package com.autohandel.vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class DeliveryCar extends Vehicle{


    private static final CarType[] mercedes = {new CarType("Mercedes", "Sprinter", 500000.0)};

    private static CarType[] renault = {new CarType("Renault", "Master", 60000.0)};
    private static CarType[] ford = {new CarType("Ford", "Transit", 40000.0)};
    private static CarType[] fiat = {new CarType("Fiat", "Ducato", 45000.0)};
    private static final CarType[][] brands = {mercedes, renault, ford, fiat};

    public DeliveryCar() {
        super();
        Integer rnd = ThreadLocalRandom.current().nextInt(0, brands.length - 1);
        CarType carType = brands[rnd][brands[rnd].length - 1];
        this.value = carType.baseValue * ThreadLocalRandom.current().nextDouble(0.9, 1.1);
        this.brand = carType.brand;
        this.model = carType.model;
        this.classification = carType.classification;
    }
}
