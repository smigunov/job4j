package ru.job4j.level2.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserMap {


    public static void main(String[] args) {
        Map<User, String> userMap = new HashMap<>();
        User user1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        User user2 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        userMap.put(user1, "first");
        userMap.put(user2, "second");

        System.out.println(userMap);
    }
}
