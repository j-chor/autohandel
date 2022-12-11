package com.autohandel;

import java.util.Scanner;

public class Gameplay {
    public static Scanner scanner = new Scanner(System.in);

    public static void mainMenu(Player player) {
        System.out.println("1. Kup auto\n" +
                "2. Sprzedaj auto\n" +
                "3. Napraw auto\n" +
                "4. Wyświetl info");
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                buyMenu(player);
                break;
            case 2:
                sellMenu(player);
                break;
            case 3:
                fixMenu(player);
                break;
            case 4:
                infoMenu(player);
                break;
        }
    }

    private static void buyMenu(Player player) {
        System.out.println("Wybierz auto do kupienia: ");
        for (int j = 0; j < player.vehiclesAvailable.size(); j++) {
            System.out.println((j + 1) + "." + player.vehiclesAvailable.get(j));
        }
        Integer choice = scanner.nextInt();
        player.buyCar(player.vehiclesAvailable.get(choice - 1));
    }

    private static void sellMenu(Player player) {
        System.out.println("Wybierz auto do sprzedania: ");
        player.printPlayerCars();
        Integer choice = scanner.nextInt();
        player.sellCar(player.vehiclesOwned.get(choice - 1));
    }

    private static void fixMenu(Player player) {
        System.out.println("Wybierz auto do naprawy: ");
        player.printPlayerCars();
        Integer choice1 = scanner.nextInt();
        System.out.println("Wybierz część do naprawy: \n" +
                "1. Hamulce\n" +
                "2. Zawieszenie\n" +
                "3. Silnik\n" +
                "4. Karoseria\n" +
                "5. Skrzynia biegów\n");
        Integer choice2 = scanner.nextInt();
        player.vehiclesOwned.get(choice1 - 1).fix(choice2);
    }

    private static void infoMenu(Player player) {
        System.out.println("Twoja kasa: " + player.cash);
        System.out.println("Twoje samochody: ");
        player.printPlayerCars();

    }
}
