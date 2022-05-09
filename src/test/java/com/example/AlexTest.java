package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AlexTest {

    private Alex alex;

    @Before
    public void init() throws Exception {
        alex = new Alex();
    }

    @Test
    public void getFriends() {
        List<String> alexFriends = List.of("Марти", "Глория", "Мелман");
        Assert.assertEquals(alexFriends, alex.getFriends());
    }

    @Test
    public void getPlaceOfLiving() {
        Assert.assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittens() {
        Assert.assertEquals(0, alex.getKittens());
    }
}