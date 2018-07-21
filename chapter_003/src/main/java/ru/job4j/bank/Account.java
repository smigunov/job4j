package ru.job4j.bank;

import java.util.List;

public class Account {
    private double value;
    private String reqs;

    public Account(String requisites, double value) {
        this.value = value;
        this.reqs = requisites;
    }

    public String getReqs() {
        return this.reqs;
    }
    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
