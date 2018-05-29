package ru.job4j.loops;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PaintTest {
    @Test
    public void testLPAD () {
        assertThat(Paint.lpad("*", 3), is("  *"));
    }

    @Test
    public void testRPAD () {
        assertThat(Paint.rpad("*", 3), is("*  "));
    }

    @Test
    public void testRepeat () {
        assertThat(Paint.repeat("*", 3), is("***"));
    }

    @Test
    public void whenHeight3Pyramid () {
        String rightResult = "  ^  " + System.lineSeparator() + " ^^^ " + System.lineSeparator() + "^^^^^";
        Paint p = new Paint();
        String actualResult = p.drawPyramid(3);
        assertThat(actualResult, is(rightResult));
    }

    @Test
    public void whenHeight4Pyramid () {
        String rightResult = "   ^   " + System.lineSeparator() + "  ^^^  " + System.lineSeparator() + " ^^^^^ " + System.lineSeparator() + "^^^^^^^";
        Paint p = new Paint();
        String actualResult = p.drawPyramid(4);
        assertThat(actualResult, is(rightResult));
    }
}
