package ru.job4j.tracker;

import java.util.*;

import ru.job4j.tracker.ConsoleInput;

public class StartUI {
    private Input input;
    private Output output;
    private Tracker tracker;

    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";

    public StartUI(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void init() {
        this.tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, this.output, this.tracker);
        boolean exitProgram = false;
        menu.fillActions();
        do {
            menu.show();   
            int key = Integer.valueOf(input.ask("Your choice:"));
            menu.select(key);            
        } while (!menu.doesHeWants2Exit());
    }
    

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        new StartUI(input, output).init();
    }
}