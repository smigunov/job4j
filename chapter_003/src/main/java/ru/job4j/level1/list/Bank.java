package ru.job4j.level1.list;

import java.util.ArrayList;
import java.util.TreeMap;

public class Bank {
    private TreeMap<User, ArrayList<String>> treemap = new TreeMap<>();
    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }
    public void add(User user, String account) {
        this.treemap.get(user).add(account);
    }

}
