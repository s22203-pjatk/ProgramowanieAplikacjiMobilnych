package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BmiCalculatorTest {
    @Test
    public void addition_isCorrect() {
        //given
        String mass = "75";
        String height = "175";
//        when:
        String bmi = BmiCalculator.calculateBMI(mass, height);
        //then
        assertEquals(bmi, "24.49");
    }
}