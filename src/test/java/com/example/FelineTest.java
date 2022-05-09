package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> felineFoods = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(felineFoods, feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        int kittensCount = (int) (Math.random() * 10);
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}