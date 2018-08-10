package ru.job4j.level_2.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EvenNumIteratorTest {
    @Test
    public void whenFirstEvenNumIsAtThirdPos () {
        EvenNumIterator it = new EvenNumIterator(new Integer[] {1, 3, 4, 5});
        int result = it.next();
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstEvenNumIsAtZeroPos () {
        EvenNumIterator it = new EvenNumIterator(new Integer[] {2, 3, 4, 5});
        int result = it.next();
        assertThat(result, is(2));
    }

    @Test
    public void whenHasNextEvenNum () {
        EvenNumIterator it = new EvenNumIterator(new Integer[] {2, 3, 4, 5});
        it.next();
        boolean b = it.hasNext();
        assertThat(b, is(true));
    }

    @Test
    public void whenDoesntHasNextEvenNum () {
        EvenNumIterator it = new EvenNumIterator(new Integer[] {2, 3, 5});
        it.next();
        boolean b = it.hasNext();
        assertThat(b, is(false));
    }
}