package ru.job4j.level_1.list;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {
    public Set<User> sort(List<User> users2Add) {
        Set<User> result = new TreeSet<>();
        result.addAll(users2Add);
        return result;
    }

    public List<User> sortNameLength(List<User> userList) {
        userList.sort(
            new Comparator<User>() {
                @Override
                public int compare(User u1, User u2) {
                    return u1.getName().length() - u2.getName().length();
                }
            }
        );
        return userList;
    }

    public List<User> sortByAllFields(List<User> userList) {
        userList.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        int r1 = u1.getName().compareTo(u2.getName()) * 10;
                        int r2 = Integer.signum(u1.getAge() - u2.getAge());
                        int r3 = r1 + r2;
                        return r3;
                        //return u1.getName().compareTo(u2.getName()) * 10  + Integer.signum(u1.getAge() - u2.getAge());
                    }
                }
        );
        return userList;
    }
}
