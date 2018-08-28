package ru.job4j.level2.List;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(0), is(1));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenAddThreeElementsThenGetArrayOfThreeElements() {
        assertThat(list.toArray(), is(new Integer[]{1, 2, 3}));
    }
    @Test
    public void whenAddThreeElementsAndDeleteThenGetArrayOfTwoElements() {
        Integer deletedValue = list.delete();
        assertThat(deletedValue, is(1));
        assertThat(list.toArray(), is(new Integer[]{2, 3}));
    }

}