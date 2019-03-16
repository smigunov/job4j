package ru.job4j.level1.tracker;

import java.util.Scanner;
import java.util.function.Consumer;

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
            int key = input.ask("Your choice:", new int[] {0, 1, 2, 3, 4, 5, 6});
            menu.select(key);
        } while (!menu.doesHeWants2Exit());
    }

//    public static void main(String[] args) {
//        Output output = new ConsoleOutput();
//        Input input = new ValidateInput(new ConsoleInput());
//        new StartUI(input, output).init();
//    }

    public static void main(String[] args) {
        Output output = new ConsumerOutput(System.out::println, System.out::println);
        Input input = new ValidateInput(
                    new ConsumerInput(
                            new Scanner(System.in)::nextLine, System.out::println
                    )
        );
        new StartUI(input, output).init();
    }
}