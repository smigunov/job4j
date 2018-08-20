package ru.job4j.level1.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void testUserConv() {
        UserConvert usrConv = new UserConvert();
        List<User> lst = new ArrayList<User>();
        lst.add(new User(1, "Вася", "Москва", 10));
        lst.add(new User(2, "Петя", "Волгоград", 20));
        lst.add(new User(3, "Маша", "Сочи", 30));
        HashMap<Integer, User> mp = usrConv.process(lst);

        assertThat(mp.keySet().toArray(), is(new int[]{1, 2, 3}));
    }

}