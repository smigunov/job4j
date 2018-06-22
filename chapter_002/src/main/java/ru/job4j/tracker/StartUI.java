package ru.job4j.tracker;

import java.util.*;

import ru.job4j.tracker.ConsoleInput;

public class StartUI {
    private Input input;
    private Output output;
    private Tracker tracker;
    
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