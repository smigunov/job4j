package ru.job4j.level2.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void testIterate() {
        Tree<Integer> t = new Tree<>(1);
        t.add(1, 2);
        t.add(1, 3);
        t.add(2, 4);
        t.add(2, 5);
        t.add(3, 6);
        t.add(3, 7);

        List<Integer> lst = new ArrayList<>();
        for (Integer i : t) {
            lst.add(i);
        }
        assertThat(lst.toArray(), is(new Integer[] {1, 2, 4, 5, 3, 6, 7}));
    }

    @Test
    public void testDuplicate() {
        Tree<Integer> t = new Tree<>(1);
        t.add(1, 2);
        t.add(1, 3);
        boolean result = t.add(2, 3);
        assertThat(result, is(false));
    }
}