package ru.job4j.level2.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiffArrayTest {
    @Test
    public void test1() {
        int[] b = new int[4];
        int[] c = new int[4];
        DiffArray.diff(new int[] {1, 2, 5, 10}, b, c);
        assertThat(b, is(new int[] {5, 2, 1, 0}));
        assertThat(c, is(new int[] {10, 0, 0, 0}));
    }

    @Test
    public void test2() {
        int[] b = new int[4];
        int[] c = new int[4];
        DiffArray.diff(new int[] {3, 4, 8, 10}, b, c);
        assertThat(b, is(new int[] {8, 4, 0, 0}));
        assertThat(c, is(new int[] {10, 3, 0, 0}));
    }

    @Test
    public void test3() {
        int[] b = new int[4];
        int[] c = new int[4];
        DiffArray.diff(new int[] {3, 4, 8, 3}, b, c);
        assertThat(b, is(new int[]{4, 3, 3, 0}));
        assertThat(c, is(new int[]{8, 0, 0, 0}));
    }
}