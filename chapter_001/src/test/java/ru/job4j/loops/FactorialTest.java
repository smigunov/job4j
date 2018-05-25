package ru.job4j.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Migunov
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
    @Test
    public void when5Then10 () {
        Factorial fctl = new Factorial();
        int result = fctl.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void when0Then1 () {
        Factorial fctl = new Factorial();
        int result = fctl.calc(0);
        assertThat(result, is(1));
    }
}
