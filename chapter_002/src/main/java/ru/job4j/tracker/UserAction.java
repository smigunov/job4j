package ru.job4j.tracker;

public interface UserAction {

    int key();
    void execute(Input input, Output output, Tracker tracker);
    String info();
}