package ru.job4j.level1.tracker;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerInput implements Input {
    Supplier<String>    inputMethod;
    Consumer<String>    outputMethod;
    public ConsumerInput(Supplier<String> inputMethod, Consumer<String> outputMethod) {
        this.inputMethod = inputMethod;
        this.outputMethod = outputMethod;
    }

    @Override
    public String ask(String question) {
        this.outputMethod.accept(question);
        return this.inputMethod.get();
    }

    @Override
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
