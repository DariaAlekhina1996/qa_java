package com.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String exception = "Используйте допустимые значения пола животного - самей или самка";
    private final String sex;
    private final boolean expected;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {" ", false}
        };
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    @Test
    public void getKittens() {
        try {
            Lion lion = new Lion(sex);
            Mockito.when(feline.getKittens()).thenReturn(1);
            Assert.assertEquals(1, lion.getKittens());
        } catch (Exception error) {
            Assert.assertEquals(exception, error.getMessage());
        }
    }

    @Test
    public void doesHaveMane() {
        try {
            Lion lion = new Lion(sex);
            Assert.assertEquals(expected, lion.doesHaveMane());
        } catch (Exception error) {
            Assert.assertEquals(exception, error.getMessage());
        }
    }

    @Test
    public void getFood() {
        try {
            Lion lion = new Lion(sex);
            List<String> lionFoods = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood("Жищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals(lionFoods, lion.getFood());
        } catch (Exception error) {
            Assert.assertEquals(exception, error.getMessage());
        }
    }


}