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

        player.generateCars(10);

        player.generateBuyers(5);

        while (true) {

            mainMenu(player);

        }

    }
}