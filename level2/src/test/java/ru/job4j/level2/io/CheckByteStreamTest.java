package ru.job4j.level2.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CheckByteStreamTest {
    @Test
    public void whenEvenNumberThenTrue() {
        CheckByteStream bs = new CheckByteStream();
        ByteArrayInputStream s = new ByteArrayInputStream(new byte[]{1,2,3});
        assertThat(bs.isNumber(s), is(true));
    }

    @Test
    public void whenNotEvenNumberThenFalse() {
        Integer testVal = 3;
        CheckByteStream bs = new CheckByteStream();
        ByteArrayInputStream s = new ByteArrayInputStream(new byte[]{3,5,7});
        assertThat(bs.isNumber(s), is(false));
    }

}