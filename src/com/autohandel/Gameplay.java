package com.autohandel;

import java.util.Scanner;

import static com.autohandel.vehicles.Vehicle.*;

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
        System.out.println("Wybierz kupca: ");
        player.printPlayerBuyers();
        Integer choice1 = scanner.nextInt();
        System.out.println("Wybierz samochód: ");
        player.printPlayerCars();
        Integer choice2 = scanner.nextInt();
        player.sellCar(player.vehiclesOwned.get(choice2 - 1), player.buyers.get(choice1 - 1));
    }

    private static void fixMenu(Player player) {
        System.out.println("Wybierz auto do naprawy: ");
        player.printPlayerCars();
        Integer choice1 = scanner.nextInt();
        System.out.println("Wybierz część do naprawy: \n" +
                "1. Hamulce: " + getPartStatus(player.vehiclesOwned.get(choice1 - 1).getPart(1)) + "\n" +
                "2. Zawieszenie: " + getPartStatus(player.vehiclesOwned.get(choice1 - 1).getPart(2)) + "\n" +
                "3. Silnik: " + getPartStatus(player.vehiclesOwned.get(choice1 - 1).getPart(3)) + "\n" +
                "4. Karoseria: " + getPartStatus(player.vehiclesOwned.get(choice1 - 1).getPart(4)) + "\n" +
                "5. Skrzynia biegów: " + getPartStatus(player.vehiclesOwned.get(choice1 - 1).getPart(5)) + "\n");
        Integer choice2 = scanner.nextInt();
        System.out.println("Wybierz mechanika: \n" +
                "1. Janusz: " + calculateFixPrice(choice2, 1) + "\n" +
                "2. Marian: " + calculateFixPrice(choice2, 2) + "\n" +
                "3. Adrian: " + calculateFixPrice(choice2, 3) + "\n");
        Integer choice3 = scanner.nextInt();
        Boolean fixSuccess = null;
        Boolean breakSuccess = false;
        Double priceMultiplier = 1.0;
        switch (choice3) {
            case 1:
                fixSuccess = true;
                break;
            case 2:
                fixSuccess = getRandomBoolean(0.9);
                priceMultiplier = 0.6;
                break;
            case 3:
                fixSuccess = getRandomBoolean(0.8);
                breakSuccess = getRandomBoolean(0.02);
                priceMultiplier = 0.3;
        }
        player.vehiclesOwned.get(choice1 - 1).fix(choice2, fixSuccess, breakSuccess, player, priceMultiplier);
    }



    private static void infoMenu(Player player) {
        System.out.println("Twoja kasa: " + player.getCash());
        System.out.println("Twoje samochody: ");
        player.printPlayerCars();

    }
}
