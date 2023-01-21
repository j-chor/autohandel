package com.autohandel;

import com.autohandel.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Integer roundCounter;
    Double cash;
    List<Vehicle> vehiclesOwned = new ArrayList<>();
    List<Vehicle> vehiclesAvailable = new ArrayList<>();
    List<Buyer> buyers = new ArrayList<>();

    public Player() {
        roundCounter = 0;
        cash = 100000.0;
    }

    public void buyCar(Vehicle car) {
        if (car.value > this.cash) {
            System.out.println("Brak wystarczającej gotówki");
        } else {
            this.cash -= car.value;
            vehiclesOwned.add(car);
            vehiclesAvailable.remove(car);
            System.out.println("Kupiłeś pojazd!");
        }
    }

    public void chargeCash(Double amount) {
        this.cash -= amount;
    }

    public Double getCash() {
        return roundTwoDecimals(this.cash);
    }

    public static Double roundTwoDecimals(Double value) {
        return (Math.round(value * 100)/100d);
    }

    public void sellCar(Vehicle car, Buyer buyer) {
        if (this.vehiclesOwned.contains(car)) {
            if (buyer.cash >= car.value) {
                if (buyer.typeWanted == car.getType()) {
                    if (buyer.brandWanted == car.getBrand()) {
                        if (!buyer.damageWanted || !(buyer.damageWanted || car.getDamage())) {
                            this.cash += car.value;
                            this.vehiclesOwned.remove(car);
                            this.buyers.remove(buyer);
                            System.out.println("Transakcja pomyślna!");
                        }
                        else System.out.println("Kupiec nie chce zepsutego pojazdu!");
                    }
                    else System.out.println("Kupiec che inną markę!");
                }
                else System.out.println("Zły rodzaj pojazdu!");
            } else System.out.println("Kupca nie stać!");
        }
    }

    public void playRound() {
        roundCounter++;
    }

    public void printPlayerCars() {
        for (int i = 0; i < this.vehiclesOwned.size(); i++) {
            System.out.println((i + 1) + "." + this.vehiclesOwned.get(i));
        }
    }

    public void printPlayerBuyers() {
        for (int i = 0; i < this.buyers.size(); i++) {
            System.out.println((i + 1) + "." + this.buyers.get(i));
        }
    }
}
