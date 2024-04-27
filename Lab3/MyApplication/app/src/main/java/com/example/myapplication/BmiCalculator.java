package com.example.myapplication;

public class BmiCalculator {

    public static String calculateBMI(String massStr, String heightStr) {
        float mass = Float.parseFloat(massStr);
        float height = Float.parseFloat(heightStr) / 100;

        float bmi = mass / (height * height);

        return String.format("%.2f", bmi);
    }
}
