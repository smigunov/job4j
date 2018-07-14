package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserSortTest {
    @Test
    public void when3UsersThenSortByAge () throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Вася", "Москва", 20));
        userList.add(new User(2, "Петя", "Волгоград", 30));
        userList.add(new User(3, "Маша", "Уфа", 10));
        UserSort us = new UserSort();
        Set<User> userSet = us.sort(userList);
        assertThat(userSet.iterator().next().getAge(), is(10));
    }
}