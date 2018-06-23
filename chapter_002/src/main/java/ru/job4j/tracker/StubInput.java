package ru.job4j.tracker;
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    public String ask(String question) {
        return answers[this.position++];
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
        if (isInRange) {
            return key;
        } else {
            throw new MenuOutException("Out of Range");
        }
    }
} 