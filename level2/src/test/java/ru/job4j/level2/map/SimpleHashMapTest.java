package ru.job4j.level2.map;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenInsertValueThenGetThisValue() {
        User usr1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        SimpleHashMap<User, Integer> shm = new SimpleHashMap<>();
        shm.insert(usr1, 1);
        assertThat(shm.get(usr1), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetNotExistingItemThenException() {
        User usr1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        User usr2 = new User("Коля", 2, new GregorianCalendar(1991, 11, 11));
        SimpleHashMap<User, Integer> shm = new SimpleHashMap<>();
        shm.insert(usr1, 1);
        Integer result = shm.get(usr2);
    }

    @Test
    public void whenInsertDoubleValueThenReturnFalse() {
        User usr1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        User usr2 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        SimpleHashMap<User, Integer> shm = new SimpleHashMap<>();
        shm.insert(usr1, 1);
        assertThat(shm.insert(usr2, 2), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteItemThenCannotGetItWithException() {
        User usr1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        User usr2 = new User("Коля", 2, new GregorianCalendar(1991, 11, 11));
        SimpleHashMap<User, Integer> shm = new SimpleHashMap<>();
        shm.insert(usr1, 1);
        shm.insert(usr2, 1);
        shm.delete(usr1);
        Integer etalon = null;
        Integer tstVal = shm.get(usr1);
    }

    @Test
    public void whenExceededLoadFactorThenResize() {
        SimpleHashMap<User, Integer> shm = new SimpleHashMap<>(2);
        User usr1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        User usr2 = new User("Коля", 2, new GregorianCalendar(1991, 11, 11));
        User usr3 = new User("Петя", 3, new GregorianCalendar(1992, 12, 12));
        shm.insert(usr1, 1);
        shm.insert(usr2, 2);
        shm.insert(usr3, 3);
        assertThat(shm.get(usr1), is(1));
        assertThat(shm.get(usr2), is(2));
        assertThat(shm.get(usr3), is(3));
    }

    @Test
    public void testIterate() {
        SimpleHashMap<User, Integer> shm = new SimpleHashMap<>();
        User usr1 = new User("Вася", 1, new GregorianCalendar(1990, 10, 10));
        User usr2 = new User("Коля", 2, new GregorianCalendar(1991, 11, 11));
        User usr3 = new User("Петя", 3, new GregorianCalendar(1992, 12, 12));
        shm.insert(usr1, 1);
        shm.insert(usr2, 2);
        shm.insert(usr3, 3);
        Set<Integer> st = new TreeSet<>();
        for (Integer val : shm) {
            st.add(val);
        }

        assertThat(st.toArray(), is(new Integer[] {1, 2, 3}));
    }

}