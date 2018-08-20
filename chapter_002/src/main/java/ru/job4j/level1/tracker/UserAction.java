package ru.job4j.level1.tracker;

public interface UserAction {

    int key();
    void execute(Input input, Output output, Tracker tracker);
    String info();
}