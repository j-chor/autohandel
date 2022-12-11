package com.autohandel;

import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarType;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.autohandel.Gameplay.mainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Autohandel!");

        Scanner scanner = new Scanner(System.in);

        Player player = new Player();

        for (int i = 0; i < 9; i++) {
            player.vehiclesAvailable.add(new Car());
        }

        while (true) {

            mainMenu(player);

        }

    }
}