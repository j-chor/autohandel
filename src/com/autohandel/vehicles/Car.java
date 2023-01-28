package com.autohandel.vehicles;

import java.util.concurrent.ThreadLocalRandom;

public class Car extends Vehicle implements HasType{
    private static final VehicleModel[] mazda = {new VehicleModel("Mazda", "RX-7", 65000.0)};
    private static final VehicleModel[] volkswagen = {new VehicleModel("Volkswagen", "Golf", 20000.0),
            new VehicleModel("Volkswagen", "Polo", 9000.0),
            new VehicleModel("Volkswagen", "Passat", 30000.0)};
    private static final VehicleModel[] audi = {new VehicleModel("Audi", "A7", 130000.0)};
    private static final VehicleModel[] skoda = {new VehicleModel("Skoda", "Fabia", 15000.0)};
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

    public static final VehicleModel[][] carBrands = {mazda, volkswagen, audi, skoda};

    public Car() {
        super();
        Integer rnd = ThreadLocalRandom.current().nextInt(0, carBrands.length);
        VehicleModel vehicleModel = carBrands[rnd][ThreadLocalRandom.current().nextInt(0, carBrands[rnd].length) ];
        this.value = vehicleModel.baseValue * ThreadLocalRandom.current().nextDouble(0.9, 1.1) * (this.brakes ? 1d : 0.95d)
                * (this.suspension ? 1d : 0.85d) * (this.engine ? 1d : 0.55d) * (this.body ? 1d : 0.75d) * (this.transmission ? 1d : 0.75d);
        // ^ Uwaga copypaste w każdym rodzaju smaochodu ^
        this.brand = vehicleModel.brand;
        this.model = vehicleModel.model;
        this.classification = vehicleModel.classification;
        this.type = "osobowe";
    }


    @Override
    public String getType() {
        return "car";
    }

}
