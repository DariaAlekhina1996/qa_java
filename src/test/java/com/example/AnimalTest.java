package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> expected;
    private Animal animal;
    private static final String allFamilies = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private final String exception = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

    public AnimalTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getSex() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {" ", List.of(" ", " ", " ")}
        };
    }

    @Before
    public void init() {
        animal = new Animal();
    }

    @Test
    public void getFood() {
        try {
            Assert.assertEquals(expected, animal.getFood(animalKind));
        } catch (Exception error) {
            Assert.assertEquals(exception, error.getMessage());
        }
    }

    @Test
    public void getFamily() {
        try {
            Assert.assertEquals(allFamilies, animal.getFamily());
        } catch (Exception error) {
            Assert.assertEquals(exception, error.getMessage());
        }
    }
}