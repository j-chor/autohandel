package com.autohandel.vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class DeliveryCar extends Vehicle {
    Integer loadspace;

    private static final VehicleModel[] mercedes = {new VehicleModel("Mercedes", "Sprinter", 500000.0)};

    private static VehicleModel[] renault = {new VehicleModel("Renault", "Master", 60000.0)};
    private static VehicleModel[] ford = {new VehicleModel("Ford", "Transit", 40000.0)};
    private static VehicleModel[] fiat = {new VehicleModel("Fiat", "Ducato", 45000.0)};
    private static final VehicleModel[][] brands = {mercedes, renault, ford, fiat};

    public DeliveryCar() {
        super();
        Integer rnd = ThreadLocalRandom.current().nextInt(0, brands.length - 1);
        VehicleModel vehicleModel = brands[rnd][brands[rnd].length - 1];
        this.value = vehicleModel.baseValue * ThreadLocalRandom.current().nextDouble(0.9, 1.1) * (this.brakes ? 1d : 0.95d)
                * (this.suspension ? 1d : 0.85d) * (this.engine ? 1d : 0.55d) * (this.body ? 1d : 0.75d) * (this.transmission ? 1d : 0.75d);
        // ^ Uwaga copypaste w każdym rodzaju smaochodu ^
        this.brand = vehicleModel.brand;
        this.model = vehicleModel.model;
        this.classification = vehicleModel.classification;
    }
}
