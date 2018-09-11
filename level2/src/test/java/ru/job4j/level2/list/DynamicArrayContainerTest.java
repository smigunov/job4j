package ru.job4j.level2.list;

import org.junit.Test;
import ru.job4j.level2.list.DynamicArrayContainer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class DynamicArrayContainerTest {
    @Test
    public void whenAdd1ValueThenGetThisValue() {
        DynamicArrayContainer<Integer> arrCont = new DynamicArrayContainer<>(10);
        arrCont.add(1);
        assertThat(arrCont.get(0), is(1));
    }

    @Test
    public void whenExceedInitialLengthThenEnlarge() {
        DynamicArrayContainer<Integer> arrCont = new DynamicArrayContainer<>(2);
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        assertThat(arrCont.getSize(), is(3));
    }

    @Test
    public void testIterator() {
        DynamicArrayContainer<Integer> arrCont = new DynamicArrayContainer<>(2);
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        List<Integer> lst = new ArrayList<>();
        for (Integer itemValue : arrCont) {
            lst.add(itemValue);
        }
        assertThat(lst.toArray(), is(new Integer[] {1, 2, 3}));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenContainerEnlargesDuringIteratorThenConcurencyException() {
        DynamicArrayContainer<Integer> arrCont = new DynamicArrayContainer<>(2);
        arrCont.add(1);
        arrCont.add(2);
        arrCont.add(3);
        for (Integer itemValue : arrCont) {
            arrCont.add(itemValue + 1);
        }
    }

}