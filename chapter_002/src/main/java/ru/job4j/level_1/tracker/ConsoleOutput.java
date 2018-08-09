package ru.job4j.level_1.tracker;

public class ConsoleOutput implements Output {   
    public void say(String str) {
        System.out.println(str);
    }
    public void answer(String str) {
        System.out.println(str);
    }
}