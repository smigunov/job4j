package ru.job4j.level_1.calculator;


public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public double getResult() {
        return this.result;
    }
}