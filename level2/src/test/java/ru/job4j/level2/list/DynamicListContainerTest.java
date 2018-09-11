package ru.job4j.level2.list;

import org.junit.Test;
import ru.job4j.level2.list.DynamicListContainer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class DynamicListContainerTest {
    @Test
    public void whenAdd1ValueThenGetThisValue() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        assertThat(arrCont.get(0), is(1));
    }

    @Test
    public void testIterator() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        arrCont.add(4);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : arrCont) {
            lst.add(itemValue);
        }

        assertThat(lst.toArray(), is(new Integer[] {1, 2, 3, 4}));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenContainerEnlargesDuringIteratorThenConcurencyException() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        for (Integer itemValue : arrCont) {
            arrCont.add(itemValue + 1);
        }
    }

    @Test
    public void testDelFirst() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        arrCont.add(4);
        arrCont.delete(0);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : arrCont) {
            lst.add(itemValue);
        }

        assertThat(lst.toArray(), is(new Integer[] {2, 3, 4}));
    }

    @Test
    public void testDelLast() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        arrCont.add(4);
        arrCont.delete(3);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : arrCont) {
            lst.add(itemValue);
        }

        assertThat(lst.toArray(), is(new Integer[] {1, 2, 3}));
    }

    @Test
    public void testDelCenter() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        arrCont.add(4);
        arrCont.delete(2);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : arrCont) {
            lst.add(itemValue);
        }

        assertThat(lst.toArray(), is(new Integer[] {1, 2, 4}));
    }

    @Test
    public void testDelSingleElement() {
        DynamicListContainer<Integer> arrCont = new DynamicListContainer<>();
        arrCont.add(1);
        arrCont.delete(0);
        assertThat(arrCont.getSize(), is(0));
    }

}