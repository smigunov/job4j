package ru.job4j.tracker;

public class ConsoleOutput implements Output {   
    public void say(String str) {
        System.out.println(str);
    }
}