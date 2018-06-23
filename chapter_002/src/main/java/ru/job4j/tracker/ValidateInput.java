package ru.job4j.tracker;

public class ValidateInput implements Input {
    //Output output;
    Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}