package ru.job4j.tracker;
class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private int maxId = 1;


    private String generateId() {
        String newId = new String("ITEM-");
        newId = newId.concat(Integer.toString(this.maxId));
        this.maxId++;
        return newId;
    }

    public void add(Item item) {       
        item.setId(generateId());
        this.items[this.position] = item;
        this.position++;
    }

    private int getPositionById(String id) {
        int result = -1;
        if (this.position > 0) {
            for (int i = 0; i < this.position; i++) {
                if (this.items[i].getId().equals(id)) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public void replace(Item item) {
        int pos = getPositionById(item.getId());
        if (pos >= 0) {
            this.items[pos] = item;
        }
    }

    public void delete(String id) {
        int pos = getPositionById(id);
        if ((pos >= 0) && (pos < this.position  - 1)) {
            System.arraycopy(this.items, pos + 1, this.items, pos, this.position - pos - 1);
        }
        this.items[this.position - 1] = null;
        this.position--;
    }

    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public Item[] findByName(String name) {
        Item[] foundItems = new Item[this.position];
        int idx = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(name)) {
                foundItems[idx] = this.items[i];
                idx++;
            }
        }
        return foundItems;
    }

    public Item findById(String id) {
        int pos = getPositionById(id);
        if (pos >= 0) {
            return  this.items[pos];
        }
        return null;
    }

    public int getCount() {
        return this.position;
    }
}