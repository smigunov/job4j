package ru.job4j.level2.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiffArrayTest {
    @Test
    public void test1() {
        DiffArray difArr = DiffArray.diff(new int[] {1, 2, 5, 10});
        assertThat(difArr.getA().toArray(), is(new Integer[] {5, 2, 1}));
        assertThat(difArr.getB().toArray(), is(new Integer[] {10}));
    }

    @Test
    public void test2() {
        DiffArray difArr = DiffArray.diff(new int[] {3, 4, 8, 10});
        assertThat(difArr.getA().toArray(), is(new Integer[] {8, 4}));
        assertThat(difArr.getB().toArray(), is(new Integer[] {10, 3}));
    }

    @Test
    public void test3() {
        DiffArray difArr = DiffArray.diff(new int[] {3, 4, 8, 3});
        assertThat(difArr.getA().toArray(), is(new Integer[]{4, 3, 3}));
        assertThat(difArr.getB().toArray(), is(new Integer[]{8}));
    }
}