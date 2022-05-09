package com.example;

import java.util.List;

public class Alex extends Lion {

    public Alex() throws Exception {
        super("Самец");
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return this.feline.getKittens(0);
    }
}