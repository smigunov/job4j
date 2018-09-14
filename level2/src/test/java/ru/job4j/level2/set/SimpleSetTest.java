package ru.job4j.level2.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddOneDouble() {
        SimpleSet<Integer> ss = new SimpleSet<>(10);
        ss.add(1);
        ss.add(2);
        ss.add(3);
        ss.add(3);
        ss.add(4);
        assertThat(ss.toArray(), is(new Integer[]{1, 2, 3, 4}));
    }

    @Test
    public void testSort() {
        SimpleSet<Integer> ss = new SimpleSet<>(10);
        ss.add(5);
        ss.add(2);
        ss.add(1);
        ss.add(3);
        ss.add(4);
        assertThat(ss.toArray(), is(new Integer[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testIterable() {
        SimpleSet<Integer> ss = new SimpleSet<>(2);
        ss.add(2);
        ss.add(4);
        ss.add(3);
        ss.add(1);
        ss.add(3);
        ss.add(4);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : ss) {
            lst.add(itemValue);
        }
        assertThat(lst.toArray(), is(new Integer[] {1, 2, 3, 4}));
    }

}