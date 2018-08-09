package ru.job4j.level_1.tracker;

public interface Input {
    String ask(String question);
    int ask(String question, int[] range); 
}