package com.autohandel;

import java.util.concurrent.ThreadLocalRandom;

public class Buyer {
    Double cash;
    String typeWanted;
    Boolean damageWanted;

    private String randomType() {
        Integer rnd = ThreadLocalRandom.current().nextInt(0,2);
        if (rnd == 0) return "car";
        else if (rnd == 1) return  "delivery";
        else return "motorcycle";
    }
    public Buyer() {
        this.cash = ThreadLocalRandom.current().nextDouble(10000, 200000);
        this.typeWanted = randomType();
        this.damageWanted = ThreadLocalRandom.current().nextDouble(0.0, 1.0) > 0.85;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "cash=" + cash +
                ", typeWanted='" + typeWanted + '\'' +
                ", damageWanted=" + damageWanted +
                '}';
    }
}
