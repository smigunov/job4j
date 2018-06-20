package ru.job4j.tracker;

import java.util.*;

import ru.job4j.tracker.ConsoleInput;

public class StartUI {
    private Input input;
    private Output output;
    private Tracker tracker;

    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";

    public StartUI(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    private void showMenu() {
        output.say("0. Add new Item");
        output.say("1. Show all items");
        output.say("2. Edit item");
        output.say("3. Delete item");
        output.say("4. Find item by Id");
        output.say("5. Find items by name");
        output.say("6. Exit Program");
    }

    private void addItemDialog() {
        String name = input.ask("Enter Item name:");
        String descr = input.ask("Enter Item description:");
        Item item = new Item(name, descr);
        this.tracker.add(item);
    }

    private void printItem(Item item) {
        StringBuffer outStr = new StringBuffer();   
        outStr.append(item.getId());
        outStr.append(" : ");
        outStr.append(item.getName());
        outStr.append(" : ");
        outStr.append(item.getDescr());
        output.say(outStr.toString());
    }

    private void showAllItems() {
        for (Item item : this.tracker.getAll()) {
            printItem(item);
        }
    }

    private void editItem() {
        Item item = this.tracker.findById(input.ask("Enter Item ID:"));
        if (item == null) {
            output.say("Item not found");
        } else {
            item.setName(input.ask("Enter new Name:"));
            item.setDescr(input.ask("Enter new Description:"));
        }
    }

    private void deleteItem() {
        String id = input.ask("Enter Item ID:");
        Item item = this.tracker.findById(id);
        if (item == null) {
            output.say("Item not found");
        } else {
            this.tracker.delete(id);
        }
    }

    private void findByID() {
        Item item = this.tracker.findById(input.ask("Enter Item ID:"));
        if (item == null) {
            output.say("Item not found");
        } else {
            printItem(item);
        }
    }

    private void findByName() {
        for (Item item : this.tracker.findByName(input.ask("Enter Item name:"))) {
            printItem(item);
        }
    }

    public void init() {
        this.tracker = new Tracker();
        boolean exitProgram = false;
        do {
            showMenu();            
            switch (input.ask("Your choice:")) {
                case ADD : 
                    addItemDialog();
                    break;
                case SHOW_ALL :
                    showAllItems();
                    break;
                case EDIT :
                    editItem();
                    break;
                case DELETE :
                    deleteItem();
                    break;
                case FIND_BY_ID : 
                    findByID();
                case FIND_BY_NAME :
                    findByName();
                    break;
                case EXIT :
                    exitProgram = true;
                    break;
                default :
                    output.say("I'm confused... Please choose the correct menu item.");
            }
        } while (!exitProgram);
    }
    

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        new StartUI(input, output).init();
    }
}