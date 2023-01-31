package com.autohandel.vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class Motorcycle extends Vehicle implements HasType{
    private static final VehicleModel[] kawasaki = {new VehicleModel("Kawasaki", "Z", 35000.0)};

    public static final VehicleModel[][] motorcycleBrands = {kawasaki};

    @Override
    public String getType() {
        return "motorcycle";
    }

    public Motorcycle() { // TODO: DRY (Car, DeliveryCar)
        super();
        Integer rnd = ThreadLocalRandom.current().nextInt(0, motorcycleBrands.length);
        VehicleModel vehicleModel = motorcycleBrands[rnd][motorcycleBrands[rnd].length - 1];
        this.value = vehicleModel.baseValue * ThreadLocalRandom.current().nextDouble(0.9, 1.1) * (this.brakes ? 1d : 0.95d)
                * (this.suspension ? 1d : 0.85d) * (this.engine ? 1d : 0.55d) * (this.body ? 1d : 0.75d) * (this.transmission ? 1d : 0.75d);
        // ^ Uwaga copypaste w każdym rodzaju smaochodu ^
        this.brand = vehicleModel.brand;
        this.model = vehicleModel.model;
        this.classification = vehicleModel.classification;
        this.type = "motocykl";
    }
}
