package com.autohandel.vehicles;

import com.autohandel.Player;

import java.util.concurrent.ThreadLocalRandom;

import static com.autohandel.Player.roundTwoDecimals;

abstract public class Vehicle implements HasType, Damageable, HasBrand {
    public Double value;
    public String type;
    String brand;
    String model;
    Integer mileage;
    String color;
    String classification;
    // true = sprawne
    Boolean brakes;
    Boolean suspension;
    Boolean engine;
    Boolean body;
    Boolean transmission;
    public Boolean isClean;

    public Boolean getPart(Integer part) {
        switch (part) {
            case 1:
                return brakes;
            case 2:
                return suspension;
            case 3:
                return engine;
            case 4:
                return body;
            case 5:
                return transmission;
            default:
                return null;
        }
    }

    static final String[] colors = {"white", "black", "red", "yellow", "silver", "green"};

    public static Boolean getRandomBoolean(Double chance) {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0) > (1.0 - chance);
    }


    public Vehicle() {
        this.mileage = ThreadLocalRandom.current().nextInt(0, 350000);
        this.color = colors[ThreadLocalRandom.current().nextInt(0, colors.length)];
        this.brakes = getRandomBoolean(0.6);
        this.suspension = getRandomBoolean(0.7);
        this.engine = getRandomBoolean(0.9);
        this.body = getRandomBoolean(0.7);
        this.transmission = getRandomBoolean(0.7);
        this.isClean = false;

    }

    public static String getPartStatus(Boolean partBoolean) {
        if (partBoolean) return "Sprawne";
        return "Zepsuty/e";
    }

    public Double calculatePartFixPrice(Integer part, Integer mechanic) {
        switch (part) {
            case 1:
                return 1000.0 * getMechanicPriceMultiplier(mechanic) * getTypeBrandPriceMultiplier(this.getType(), this.getBrand());
            case 2:
                return 2000 * getMechanicPriceMultiplier(mechanic) * getTypeBrandPriceMultiplier(this.getType(), this.getBrand());
            case 3:
                return 10000 * getMechanicPriceMultiplier(mechanic) * getTypeBrandPriceMultiplier(this.getType(), this.getBrand());
            case 4:
                return 3000 * getMechanicPriceMultiplier(mechanic) * getTypeBrandPriceMultiplier(this.getType(), this.getBrand());
            case 5:
                return 5000 * getMechanicPriceMultiplier(mechanic) * getTypeBrandPriceMultiplier(this.getType(), this.getBrand());
            default:
                return null;
        }
    }

    private static Double getMechanicPriceMultiplier(Integer mechanic) {
        switch (mechanic) {
            case 1:
                return 1.0;
            case 2:
                return 0.6;
            case 3:
                return 0.3;
            default:
                return null;
        }
    }

    private static Double getTypeBrandPriceMultiplier(String type, String brand) {
        switch (type) {
            case "car":
                switch (brand) {
                    case "Audi":
                        return 1.5;
                    case "Skoda":
                    case "Volswagen":
                        return 1.3;
                    case "Mazda":
                        return 1.2;
                }
            case "delivery":
                switch (brand) {
                    case "Ford":
                        return 1.3;
                    case "Fiat":
                    case "Renault":
                        return 1.2;
                    case "Mercedes":
                        return 1.4;
                }
            case "motorcycle":
                switch (brand) {
                    case "Kawasaki":
                        return 0.8;
                }
            default:
                System.out.println("BUG!!");
                return 2.0;
        }
    }

    public void washCar(Player player) {
        player.chargeCash(100.0);
        this.isClean = true;
        System.out.println("Umyto samochód");
    }

    public void fix(Integer part, Boolean fixSuccess, Boolean breakSuccess, Player player, Double price) {
        if (breakSuccess) {
            breakPart(ThreadLocalRandom.current().nextInt(1, 6));
            System.out.println("Któraś z części została zepsuta!");
        }
        player.chargeCash(price);
        switch (part) {
            case 1:
                if (fixSuccess) {
                    this.brakes = true;
                    this.value *= 1.1;
                    System.out.println("Naprawiono hamulce");
                } else {
                    System.out.println("Naprawa nieudana");
                }
                break;
            case 2:
                if (fixSuccess) {
                    this.suspension = true;
                    this.value *= 1.2;
                    System.out.println("Naprawiono zawieszenie");
                } else {
                    System.out.println("Naprawa nieudana");
                }
                break;
            case 3:
                if (fixSuccess) {
                    this.engine = true;
                    this.value *= 2;
                    System.out.println("Naprawiono silnik");
                } else {
                    System.out.println("Naprawa nieudana");
                }
                break;
            case 4:
                if (fixSuccess) {
                    this.body = true;
                    this.value *= 1.5;
                    System.out.println("Naprawiono karoserię");
                } else {
                    System.out.println("Naprawa nieudana");
                }
                break;
            case 5:
                if (fixSuccess) {
                    this.transmission = true;
                    this.value *= 1.5;
                    System.out.println("Naprawiono skrzynię biegów");
                } else {
                    System.out.println("Naprawa nieudana");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + part);
        }
        player.finishRound();

    }

    private void breakPart(Integer part) {
        switch (part) {
            case 1:
                this.brakes = false;
                break;
            case 2:
                this.suspension = false;
                break;
            case 3:
                this.engine = false;
                break;
            case 4:
                this.body = false;
                break;
            case 5:
                this.transmission = false;
                break;
        }
    }

    @Override
    public Boolean getDamage() { //true = has damage, false = no damage
        return !(this.brakes & this.suspension & this.body & this.transmission & this.engine);
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand + " " + model + ", Wartość: " + roundTwoDecimals(value)
                + ", Klasa pojazdu: " + this.classification + ", Typ pojazdu: " + this.type + ", Przebieg: " + mileage + ", Sprawność: " + "Hamulce: "
                + getPartStatus(this.brakes) + ", Zawieszenie: "
                + getPartStatus(this.suspension) + ", Silnik: " + getPartStatus(this.engine)
                + ", Karoseria: " + getPartStatus(this.body) + ", Skrzynia biegów: "
                + getPartStatus(this.transmission) + ", Czystość: " + this.isClean;
    }
}
