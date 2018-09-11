package ru.job4j.level2.list;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleStackTest {
    @Test
    public void whenAdd2ValuesThenGetThem() {
        SimpleStack<Integer> st = new SimpleStack<>();
        st.push(1);
        st.push(2);
        assertThat(st.poll(), is(2));
        assertThat(st.poll(), is(1));
    }
}