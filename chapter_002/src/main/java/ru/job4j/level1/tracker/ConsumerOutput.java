package ru.job4j.level1.tracker;

import java.util.function.Consumer;

public class ConsumerOutput implements Output {
    Consumer<String> sayMethod;
    Consumer<String> answerMethod;
    public ConsumerOutput(Consumer<String> sayMethod, Consumer<String> answerMethod) {
        //this.outputMethod = outputMethod;
        this.sayMethod = sayMethod;
        this.answerMethod = answerMethod;
    }

    @Override
    public void say (String str) {
        sayMethod.accept(str);
    }

    @Override
    public void answer (String str) {
        answerMethod.accept(str);
    }
}
