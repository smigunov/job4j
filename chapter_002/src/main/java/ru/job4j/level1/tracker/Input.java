package ru.job4j.level1.tracker;

public interface Input {
    String ask(String question);
    int ask(String question, int[] range); 
}