package ru.job4j.level_1.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean isInRange = false;
        for (int val : range) {
            if (key == val) {
                isInRange = true;
                break;
            }
        }
        if (!isInRange) {
            throw new MenuOutException("Out of Range");
        }
        return key;
    }
}