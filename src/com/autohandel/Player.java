package com.autohandel;

import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.DeliveryCar;
import com.autohandel.vehicles.Motorcycle;
import com.autohandel.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static com.autohandel.Buyer.randomInt;

public class Player {
    public Integer getRoundCounter() {
        return roundCounter;
    }

    private Integer roundCounter = 0;
    Double cash;
    List<Vehicle> vehiclesOwned = new ArrayList<>();
    List<Vehicle> vehiclesAvailable = new ArrayList<>();
    List<Buyer> buyers = new ArrayList<>();

    public Player() {
        roundCounter = 0;
        cash = 100000.0;
    }

    public void finishRound() {
        roundCounter++;
    }

    public void buyCar(Vehicle car) {
        if (car.value > this.cash) {
            System.out.println("Brak wystarczającej gotówki");
        } else {
            this.cash -= car.value;
            vehiclesOwned.add(car);
            vehiclesAvailable.remove(car);
            System.out.println("Kupiłeś pojazd!");
            this.finishRound();
        }
    }

    public void chargeCash(Double amount) {
        this.cash -= amount;
    }

    public void generateCars(Integer amount) {
        int random1 = randomInt(0, 11);
        int random2 = randomInt(0, 11 - random1);
        int random3 = 10 - random1 - random2;
        for (int i = 0; i < random1; i++) {
            this.vehiclesAvailable.add(new Car());
        }
        for (int i = 0; i < random2; i++) {
            this.vehiclesAvailable.add(new DeliveryCar());
        }
        for (int i = 0; i < random3; i++) {
            this.vehiclesAvailable.add(new Motorcycle());
        }
    }

    public void generateBuyers(Integer amount) {
        for (int i = 0; i < amount; i++) {
            this.buyers.add(new Buyer());
        }

    }

    public Double getCash() {
        return roundTwoDecimals(this.cash);
    }

    public static Double roundTwoDecimals(Double value) {
        return (Math.round(value * 100) / 100d);
    }

    public void sellCar(Vehicle car, Buyer buyer) {
        if (this.vehiclesOwned.contains(car)) {
            if (buyer.cash >= car.value) {
                if (buyer.typeWanted == car.getType()) {
                    if (buyer.brandWanted1 == car.getBrand() || buyer.brandWanted2 == car.getBrand()) {
                        if (buyer.damageWanted || !car.getDamage()) {
                            if (car.isClean) {
                                this.cash += car.value;
                                this.vehiclesOwned.remove(car);
                                this.buyers.remove(buyer);
                                System.out.println("Transakcja pomyślna!");
                                this.generateBuyers(2);
                                this.finishRound();
                            } else System.out.println("Kupiec nie chce brudengo auta!");
                        } else System.out.println("Kupiec nie chce zepsutego pojazdu!");
                    } else System.out.println("Kupiec che inną markę!");
                } else System.out.println("Zły rodzaj pojazdu!");
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
