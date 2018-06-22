package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Output output;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private boolean exitProgram = false;

    public MenuTracker(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }

    public void fillActions() {
        //this.actions[0] = this.new AddItem(this.input, this.output, this.tracker);
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAll();
        this.actions[2] = this.new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = this.new FindByID();
        this.actions[5] = this.new FindByName();
    }

    public void select(int key) {
        if (key == 6) {
            this.exitProgram = true;
        } else {
            this.actions[key].execute(this.input, this.output, this.tracker);
        }
    }

    public boolean doesHeWants2Exit() {
        return this.exitProgram;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                this.output.say(action.info());
            }
        }
        this.output.say("6. Exit Program");
    }

    private class AddItem implements UserAction {
        public int key() { 
            return 0;
        }

        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Enter Item name:");
            String descr = input.ask("Enter Item description:");
            Item item = new Item(name, descr);
            tracker.add(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }
    }

    private static class ShowAll implements UserAction {
        public int key() { 
            return 1;
        }

        public void execute(Input input, Output output, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                output.answer(item.toString());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");            
        }
    }

    private class EditItem implements UserAction {
        public int key() { 
            return 2;
        }

        public void execute(Input input, Output output, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter Item ID:"));
            if (item == null) {
                output.answer("Item not found");
            } else {
                item.setName(input.ask("Enter new Name:"));
                item.setDescr(input.ask("Enter new Description:"));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");            
        }
    }

    private class FindByID implements UserAction {
        public int key() { 
            return 4;
        }

        public void execute(Input input, Output output, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter Item ID:"));
            if (item == null) {
                output.answer("Item not found");
            } else {
                output.answer(item.toString());
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");            
        }
    }
    private class FindByName implements UserAction {
        public int key() { 
            return 5;
        }
    
        public void execute(Input input, Output output, Tracker tracker) {
            for (Item item : tracker.findByName(input.ask("Enter Item name:"))) {
                output.answer(item.toString());
            }
        }
    
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name");            
        }
    }
}

class DeleteItem implements UserAction {
    public int key() { 
        return 3;
    }

    public void execute(Input input, Output output, Tracker tracker) {
        String id = input.ask("Enter Item ID:");
        Item item = tracker.findById(id);
        if (item == null) {
            output.answer("Item not found");
        } else {
            tracker.delete(id);
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");            
    }
}