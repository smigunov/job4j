package ru.job4j.level_1.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserSortTest {
    @Test
    public void when3UsersThenSortByAge() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Вася", "Москва", 20));
        userList.add(new User(2, "Петя", "Волгоград", 30));
        userList.add(new User(3, "Маша", "Уфа", 10));
        UserSort us = new UserSort();
        Set<User> userSet = us.sort(userList);
        assertThat(userSet.iterator().next().getAge(), is(10));
    }

    @Test
    public void testSortNameLength() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "11", "Москва", 20));
        userList.add(new User(2, "1", "Волгоград", 30));
        userList.add(new User(3, "111", "Уфа", 10));
        UserSort us = new UserSort();
        List<User> userSort = us.sortNameLength(userList);
        assertThat(userSort.iterator().next().getName(), is("1"));
    }

    @Test
    public void testSortByAllFields() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "11", "Москва", 20));
        userList.add(new User(2, "1", "Волгоград", 30));
        userList.add(new User(2, "1", "Волгоград", 40));
        userList.add(new User(3, "111", "Уфа", 60));
        userList.add(new User(3, "111", "Уфа", 50));

        UserSort us = new UserSort();
        List<User> userSort = us.sortByAllFields(userList);

        String resultStr = new String();
        for (User user : userSort) {
            resultStr += user.getName() + user.getAge() + ".";
        }
        assertThat(resultStr, is("130.140.1120.11150.11160."));
    }
}