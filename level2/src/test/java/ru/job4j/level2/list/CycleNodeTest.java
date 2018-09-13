package ru.job4j.level2.list;


import org.junit.Test;
import ru.job4j.level2.list.DynamicListContainer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class CycleNodeTest {
    @Test
    public void whenCycleByFirstNode() {
        CycleNode<Integer> n1 = new CycleNode<>();
        CycleNode<Integer> n2 = new CycleNode<>();
        CycleNode<Integer> n3 = new CycleNode<>();
        CycleNode<Integer> n4 = new CycleNode<>();

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n1;

        assertThat(n1.hasCycle(), is(true));
    }

    @Test
    public void whenCycleBySecondNode() {
        CycleNode<Integer> n1 = new CycleNode<>();
        CycleNode<Integer> n2 = new CycleNode<>();
        CycleNode<Integer> n3 = new CycleNode<>();
        CycleNode<Integer> n4 = new CycleNode<>();

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        assertThat(n1.hasCycle(), is(true));
    }

    @Test
    public void whenNotCycle() {
        CycleNode<Integer> n1 = new CycleNode<>();
        CycleNode<Integer> n2 = new CycleNode<>();
        CycleNode<Integer> n3 = new CycleNode<>();
        CycleNode<Integer> n4 = new CycleNode<>();
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        assertThat(n1.hasCycle(), is(false));
    }
}