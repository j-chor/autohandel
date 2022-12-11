package com.autohandel.vehicles;

public class CarType {
    String brand;
    String model;
    String classification;
    Double baseValue;

    public CarType(String brand, String model, Double baseValue) {
        this.brand = brand;
        this.model = model;
        this.baseValue = baseValue;

        if (baseValue >= 30000.0) {
            this.classification = "Premium";
        } else if (baseValue >=10000.0) {
            this.classification = "Standard";
        }
        else this.classification = "Budget";
    }
}
