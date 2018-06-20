package ru.job4j.tracker;
public class StubOutput implements Output {
    private String[] phrases;
    private int position = 0;
    public StubOutput(String[] phrases) {
        this.phrases = phrases;
    }
    public void say(String str) {
        phrases[this.position++] = str;
    }
} 