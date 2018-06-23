package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    Output output;
    public ValidateInput(Output output) {
        this.output = output;
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        System.out.println("ValidateInput");
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                this.output.say("Please select key from menu");
            } catch (NumberFormatException nfe) {
                this.output.say("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}