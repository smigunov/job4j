package ru.job4j.level2.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Store {
    private static Map<Integer, User> fillMap(List<User> lst) {
        Map<Integer, User> map = new HashMap<>();
        for (User usr : lst) {
            map.put(usr.id, usr);
        }
        return map;
    }

    public static Info diff(List<User> previous, List<User> current){
        Info result = new Info();
        Map<Integer, User> prevMap = fillMap(previous);
        Map<Integer, User> curMap = fillMap(current);
        for (User usr : current) {
            User existingUser = prevMap.get(usr.id);
            if (existingUser == null){
                result.created++;
            } else if (!existingUser.name.equals(usr.name)) {
                result.edited++;
            }
        }
        for (User usr : previous) {
            User existingUser = curMap.get(usr.id);
            if (existingUser == null) {
                result.deleted++;
            }
        }
        return result;
    }

    static class User {
        int     id;
        String  name;
        public User(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
}
