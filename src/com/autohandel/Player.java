package com.autohandel;

import com.autohandel.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Integer roundCounter;
    Double cash;
    List<Vehicle> vehiclesOwned = new ArrayList<>();
    List<Vehicle> vehiclesAvailable = new ArrayList<>();
    List<Client> clients = new ArrayList<>();

    public Player() {
        roundCounter = 0;
        cash = 100000.0;
    }

    public void buyCar(Vehicle car) {
        if (car.value > this.cash) {
            System.out.println("Brak wystarczającej gotówki");
        }
        else {
            this.cash -= car.value;
            vehiclesOwned.add(car);
            vehiclesAvailable.remove(car);
            System.out.println("Kupiłeś pojazd!");
        }
    }

    public void sellCar(Vehicle car) {
        if (this.vehiclesOwned.contains(car)) {
            this.cash += car.value;
            this.vehiclesOwned.remove(car);
        }
    }
    public void playRound() {
        roundCounter++;
    }

    public void printPlayerCars() {
        for (int i = 0; i < this.vehiclesOwned.size(); i++) {
            System.out.println((i+1) + "." + this.vehiclesOwned.get(i));
        }
    }
}
