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
        this.actions[0] = this.new AddItem(0, "Add new item");
        this.actions[1] = new MenuTracker.ShowAll(1, "Show all items");
        this.actions[2] = this.new EditItem(2, "Edit item");
        this.actions[3] = new DeleteItem(3, "Delete item");
        this.actions[4] = this.new FindByID(4, "Find item by Id");
        this.actions[5] = this.new FindByName(5, "Find item by name");
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

    private class AddItem extends BaseAction {        
        public AddItem(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Output output, Tracker tracker) {
            String name = input.ask("Enter Item name:");
            String descr = input.ask("Enter Item description:");
            Item item = new Item(name, descr);
            tracker.add(item);
        }
    }

    private static class ShowAll extends BaseAction  {
        public ShowAll(int key, String name) {
            super(key, name);
        }        
        public void execute(Input input, Output output, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                output.answer(item.toString());
            }
        }
    }

    private class EditItem extends BaseAction  {
        public EditItem(int key, String name) {
            super(key, name);
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
    }

    private class FindByID extends BaseAction  {
        public FindByID(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Output output, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter Item ID:"));
            if (item == null) {
                output.answer("Item not found");
            } else {
                output.answer(item.toString());
            }
        }
    }
    private class FindByName extends BaseAction  {
        public FindByName(int key, String name) {
            super(key, name);
        }
        public void execute(Input input, Output output, Tracker tracker) {
            for (Item item : tracker.findByName(input.ask("Enter Item name:"))) {
                output.answer(item.toString());
            }
        }
    }
}

class DeleteItem extends BaseAction  {
    public DeleteItem(int key, String name) {
        super(key, name);
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
}