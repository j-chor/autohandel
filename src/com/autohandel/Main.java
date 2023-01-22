package com.autohandel;

import com.autohandel.vehicles.Car;

import java.util.InputMismatchException;
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

        do {
            try {
                System.out.println("Tura nr " + player.getRoundCounter());
                mainMenu(player);
            } catch (InputMismatchException e) {
                System.out.println("Zła wartość");
            }
            Gameplay.scanner.nextLine();
        } while (player.getCash() < 200000.00);
        System.out.println("Udało ci się podowoić ilość gotówki - wygrałeś! Liczba ruchów: " + player.getRoundCounter());

    }
}