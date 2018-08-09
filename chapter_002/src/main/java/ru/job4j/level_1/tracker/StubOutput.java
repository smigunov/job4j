package ru.job4j.level_1.tracker;
public class StubOutput implements Output {
    private String[] phrases;
    private int position = 0;
    public StubOutput(String[] phrases) {
        this.phrases = phrases;
    }
    public void say(String str) {
        return;
    }
    
    public void answer(String str) {
        phrases[this.position++] = str;
    }

    public String[] getPhrases() {
        String[] result = new String[this.position];
        for (int i = 0; i < this.position; i++) {
            result[i] = this.phrases[i];
        }
        return result;
    }
} 