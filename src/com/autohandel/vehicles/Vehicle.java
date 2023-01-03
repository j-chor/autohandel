package com.autohandel.vehicles;

import com.autohandel.Player;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.autohandel.Player.roundTwoDecimals;

abstract public class Vehicle {
    public Double value;
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

    public Boolean getPart(Integer part) {
        switch (part) {
            case 1: return brakes;
            case 2: return suspension;
            case 3 : return engine;
            case 4: return body;
            case 5: return transmission;
            default: return null;
        }
    }

    static final String[] colors = {"white", "black", "red", "yellow", "silver", "green"};

    public static Boolean getRandomBoolean(Double chance) {
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

    public static String getPartStatus(Boolean partBoolean) {
        if (partBoolean) return "Sprawne";
        return "Zepsuty/e";
    }

    public static Double calculateFixPrice(Integer part, Integer mechanic) {
        switch (part) {
            case 1:
                return 1000.0 * getPriceMultiplier(mechanic);
            case 2:
                return 2000 * getPriceMultiplier(mechanic);
            case 3:
                return 10000 * getPriceMultiplier(mechanic);
            case 4:
                return 3000 * getPriceMultiplier(mechanic);
            case 5:
                return 5000 * getPriceMultiplier(mechanic);
            default:
                return null;
        }
    }

    private static Double getPriceMultiplier(Integer mechanic) {
        switch (mechanic) {
            case 1:
                return 1.0;
            case 2:
                return 0.6;
            case 3:
                return 0.3;
            default:
                return null;
        }
    }

    public void fix(Integer part, Boolean fixSuccess, Boolean breakSuccess, Player player, Double priceMultiplier) {
        if (breakSuccess) {
            breakPart(ThreadLocalRandom.current().nextInt(1, 6));
            System.out.println("Któraś z części została zepsuta!");
        }
        switch (part) {
            case 1:
                player.chargeCash(1000.0 * priceMultiplier);
                if (fixSuccess) {
                    this.brakes = true;
                    this.value *= 1.1;
                    System.out.println("Naprawiono hamulce");
                    break;
                } else System.out.println("Naprawa nieudana");
            case 2:
                if (fixSuccess) {
                    this.suspension = true;
                    this.value *= 1.2;
                    System.out.println("Naprawiono zawieszenie");
                    break;
                } else System.out.println("Naprawa nieudana");
            case 3:
                if (fixSuccess) {
                    this.engine = true;
                    this.value *= 2;
                    System.out.println("Naprawiono silnik");
                    break;
                } else System.out.println("Naprawa nieudana");
            case 4:
                if (fixSuccess) {
                    this.body = true;
                    this.value *= 1.5;
                    System.out.println("Naprawiono karoserię");
                    break;
                } else System.out.println("Naprawa nieudana");
            case 5:
                if (fixSuccess) {
                    this.transmission = true;
                    this.value *= 1.5;
                    System.out.println("Naprawiono skrzynię biegów");
                    break;
                } else System.out.println("Naprawa nieudana");
            default:
                throw new IllegalStateException("Unexpected value: " + part);
        }

    }

    private void breakPart(Integer part) {
        switch (part) {
            case 1:
                this.brakes = false;
                break;
            case 2:
                this.suspension = false;
                break;
            case 3:
                this.engine = false;
                break;
            case 4:
                this.body = false;
                break;
            case 5:
                this.transmission = false;
                break;
        }
    }

    @Override
    public String toString() {
        return brand + " " + model + ", Wartość: " + roundTwoDecimals(value)
                + ", Klasa pojazdu: " + this.classification + ", Przebieg: " + mileage + ", Sprawność: " + "Hamulce: "
                + getPartStatus(this.brakes) + ", Zawieszenie: "
                + getPartStatus(this.suspension) + ", Silnik: " + getPartStatus(this.engine)
                + ", Karoseria: " + getPartStatus(this.body) + ", Skrzynia biegów: "
                + getPartStatus(this.transmission);
    }

    //    nwm na chuj mi to:
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
