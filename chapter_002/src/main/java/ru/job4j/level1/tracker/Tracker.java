package ru.job4j.level1.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Tracker {
    private List<Item> items = new ArrayList<Item>();
    private int maxId = 1;


    private String generateId() {
        String newId = new String("ITEM-");
        newId = newId.concat(Integer.toString(this.maxId));
        this.maxId++;
        return newId;
    }

    public void add(Item item) {       
        item.setId(generateId());
        this.items.add(item);
    }

    private int getPositionById(String id) {
        int result = -1;
        if (this.items.size() > 0) {
            for (int i = 0; i < this.items.size(); i++) {
                if (this.items.get(i).getId().equals(id)) {
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
            this.items.set(pos, item);
        }
    }

    public void delete(String id) {
        for (Item item : this.items) {
            if (id.equals(item.getId())) {
                this.items.remove(item);
                break;
            }
        }
    }

    public List<Item> getAll() {
        return this.items;
    }


    public List<Item> findByName(String name) {
        Predicate<Item> searchByName = itm -> itm.getName().equals(name);
        return this.items.stream().filter(searchByName).collect(Collectors.toList());
    }

    public Item findById(String id) {
        Predicate<Item> searchById = itm -> itm.getId().equals(id);
        return this.items.stream().filter(searchById).findFirst().get();
    }

    public int getCount() {
        return this.items.size();
    }
}