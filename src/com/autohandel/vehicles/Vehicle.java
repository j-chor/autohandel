package com.autohandel.vehicles;

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

    public Vehicle() {
        // TODO: generator pojazdu
    }

    public Vehicle(Double value, String brand, String model, Integer mileage, String color, String classification, Boolean brakes, Boolean suspension, Boolean engine, Boolean body, Boolean transmission) {
        this.value = value;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.color = color;
        this.classification = classification;
        this.brakes = brakes;
        this.suspension = suspension;
        this.engine = engine;
        this.body = body;
        this.transmission = transmission;
    }
}
