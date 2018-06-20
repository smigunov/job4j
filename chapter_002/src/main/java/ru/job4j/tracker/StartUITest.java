package ru.job4j.tracker;

public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"create stub task"});
        Output output = new StubOutput(new String[100]);
        new StartUI(input, output).init();
    }
}