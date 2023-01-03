package com.autohandel;

import com.autohandel.vehicles.Car;

import java.util.Scanner;

import static com.autohandel.Gameplay.mainMenu;
import static com.autohandel.vehicles.Vehicle.getRandomBoolean;

public class Main {
    public static void main(String[] args) {
        System.out.println("Autohandel!");

        Scanner scanner = new Scanner(System.in);

        Player player = new Player();

        for (int i = 0; i < 9; i++) {
            player.vehiclesAvailable.add(new Car());
        }

        for (int i = 0; i < 5; i++) {
            player.buyers.add(new Buyer());
        }

        while (true) {

            mainMenu(player);

        }

    }
}