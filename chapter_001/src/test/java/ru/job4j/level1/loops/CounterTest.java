package ru.job4j.level1.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Migunov
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    @Test
    public void when1And10Then30() {
        Counter cnt = new Counter();
        int result = cnt.add(1, 10);
        assertThat(result, is(30));
    }
}
