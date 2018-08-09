package ru.job4j.level_2.iterator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class IteratorAnyArrayTest {
    @Test
    public void whenCallNextLineThenMoveIPointer () {
        IteratorAnyArray<Integer> itr = new IteratorAnyArray<Integer>(new Integer[][]{{1, 1, 1}, {2, 3}});
        itr.next();
        itr.next();
        itr.next();
        Integer result = itr.next();
        assertThat(result, is(2));
    }

    @Test
    public void whenStandOnLastPositionThenHasNextIsFalse () {
        IteratorAnyArray<Integer> itr = new IteratorAnyArray<Integer>(new Integer[][]{{1}, {2, 3}});
        itr.next();
        itr.next();
        itr.next();
        assertThat(itr.hasNext(), is(false)) ;
    }
}