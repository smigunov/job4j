package ru.job4j.level_2.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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

    private Iterator<Integer> it;

    @Before
    public void setUp(){
        it = new EvenNumIterator(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers(){
        it = new EvenNumIterator(new Integer[]{1});
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven(){
        it = new EvenNumIterator(new Integer[]{2,4,6,8});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }

    @Test
    public void testAndrew() {
        it = new EvenNumIterator(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        List<Integer> lst = new ArrayList<Integer>();
        while(it.hasNext()) {
            lst.add(it.next());
        }
        assertThat(lst.toArray(), is(new Integer[] {2,4,6,8}));
    }
}