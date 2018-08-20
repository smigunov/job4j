package ru.job4j.level1.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Migunov
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstLessSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenSummation1And2Then3() {
        Max maxim = new Max();
        int result = maxim.summation(1, 2);
        assertThat(result, is(3));
    }
}
