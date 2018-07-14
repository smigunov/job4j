package ru.job4j.list;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {
    public Set<User> sort (List<User> users2Add) {
        Set<User> result = new TreeSet<>();
        result.addAll(users2Add);
        return result;
    }
}
