package com.autohandel.vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class Motorcycle extends Vehicle {
    private static final CarType[] kawasaki = {new CarType("Kawasaki", "Z", 35000.0)};

    private static final CarType[][] brands = {kawasaki};

    public Motorcycle() { // TODO: DRY (Car, DeliveryCar)
        super();
        Integer rnd = ThreadLocalRandom.current().nextInt(0, brands.length - 1);
        CarType carType = brands[rnd][brands[rnd].length - 1];
        this.value = carType.baseValue * ThreadLocalRandom.current().nextDouble(0.9, 1.1) * (this.brakes ? 1d : 0.95d)
                * (this.suspension ? 1d : 0.85d) * (this.engine ? 1d : 0.55d) * (this.body ? 1d : 0.75d) * (this.transmission ? 1d : 0.75d);
        // ^ Uwaga copypaste w każdym rodzaju smaochodu ^
        this.brand = carType.brand;
        this.model = carType.model;
        this.classification = carType.classification;
    }
}
