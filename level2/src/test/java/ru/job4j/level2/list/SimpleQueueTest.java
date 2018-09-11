package ru.job4j.level2.list;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleQueueTest {
    @Test
    public void whenAdd3ValuesThenGetThem() {
        SimpleQueue<Integer> q = new SimpleQueue<>();
        q.push(1);
        q.push(2);
        q.push(3);
        assertThat(q.poll(), is(1));
        assertThat(q.poll(), is(2));
        assertThat(q.poll(), is(3));
    }
}