package com.autohandel;

import java.util.concurrent.ThreadLocalRandom;

import static com.autohandel.vehicles.Car.carBrands;
import static com.autohandel.vehicles.DeliveryCar.deliveryBrands;
import static com.autohandel.vehicles.Motorcycle.motorcycleBrands;

public class Buyer {
    final String brandWanted1;
    final String brandWanted2;
    final Double cash;
    final String typeWanted;
    final Boolean damageWanted;

    public static Integer randomInt(Integer range1, Integer range2) {
        return ThreadLocalRandom.current().nextInt(range1, range2);
    }

    private String randomType() {
        Integer rnd = ThreadLocalRandom.current().nextInt(0, 3);
        if (rnd == 0) return "car";
        else if (rnd == 1) return "delivery";
        else return "motorcycle";
    }

    private String randomBrand(String carType) {
        if (carType == "car") {
            return carBrands[randomInt(0, carBrands.length)][0].getBrand();
        } else if (carType == "delivery") {
            return deliveryBrands[randomInt(0, deliveryBrands.length)][0].getBrand();
        } else return motorcycleBrands[randomInt(0, motorcycleBrands.length)][0].getBrand();
    }

    public Buyer() {
        this.cash = ThreadLocalRandom.current().nextDouble(10000, 200000);
        this.typeWanted = randomType();
        this.brandWanted1 = randomBrand(this.typeWanted);
        this.brandWanted2 = randomBrand(this.typeWanted);
        this.damageWanted = ThreadLocalRandom.current().nextDouble(0.0, 1.0) > 0.85;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "brandWanted1='" + brandWanted1 + '\'' +
                ", brandWanted2='" + brandWanted2 + '\'' +
                ", cash=" + cash +
                ", typeWanted='" + typeWanted + '\'' +
                ", damageWanted=" + damageWanted +
                '}';
    }
}
