package com.autohandel;

import com.autohandel.vehicles.Car;

public class Main {
    public static void main(String[] args) {
        System.out.println("Autohandel!");
        Player player = new Player();
        player.vehiclesOwned.add(new Car(5000.0, "Volkswagen", "Polo", 300000, "silver", "budget", true, true, true, true, true));
        System.out.println(player.vehiclesOwned);
        Object myObj = "haha";
        System.out.println(myObj);

    }
}