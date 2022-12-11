package com.autohandel.vehicles;

import java.util.List;

public class Car extends Vehicle{

    private String[] mazda = {"RX-7"};
    private String[] volkswagen = {"Golf", "Polo"};
    private String[] audi;
    private String[] skoda;
    private String[] ford;
    private String[] toyota;
    private String[] mercedes;
    private String[] subaru;
    private String[] renault;
    private String[] mitsubishi;
    private String[] fiat;
    private String[] honda;
    private String[] hyundai;
    private String[] ferrari;
    private String[][] brands = {mazda, volkswagen, audi, skoda, ford, toyota, mercedes, fiat, subaru, renault, mitsubishi, fiat, honda, hyundai, ferrari};


    public Car(String brand, String model) {

    }
    public Car(Double value, String brand, String model, Integer mileage, String color, String classification, Boolean brakes, Boolean suspension, Boolean engine, Boolean body, Boolean transmission) {
        super(value, brand, model, mileage, color, classification, brakes, suspension, engine, body, transmission);
    }
}
