package ru.job4j.level2.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SimpleArrayTest {
    @Test
    public void whenAdd1ValueThenGetThisValue() {
        SimpleArray<Integer> sa = new SimpleArray<>(1);
        sa.add(555);
        assertThat(sa.get(0), is(555));
    }

    @Test
    public void whenDeleteThenIterateCountReducedByOne() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        sa.delete(2);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : sa) {
            lst.add(itemValue);
        }
        assertThat(lst.toArray(), is(new Integer[]{1, 2, 4}));
    }

}