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
        cash = 10000.0;
    }

    public void playRound() {
        roundCounter++;
    }
}
