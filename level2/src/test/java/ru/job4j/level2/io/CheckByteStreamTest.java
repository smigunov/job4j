package ru.job4j.level2.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class CheckByteStreamTest {
    @Test
    public void whenEvenNumberThenTrue() {
        CheckByteStream bs = new CheckByteStream();
        //ByteArrayInputStream s = new ByteArrayInputStream(new byte[]{1,2,3});
        ByteArrayInputStream s = new ByteArrayInputStream("123".getBytes());
        assertThat(bs.isNumber(s), is(true));
    }

    @Test
    public void whenNotEvenNumberThenFalse() {
        Integer testVal = 3;
        CheckByteStream bs = new CheckByteStream();
        ByteArrayInputStream s = new ByteArrayInputStream("357".getBytes());
        assertThat(bs.isNumber(s), is(false));
    }

    @Test
    public void whenAbuseThenExclude() {
        String[] abuseWords = {"fucking", "shit"};
        CheckByteStream cbs = new CheckByteStream();
        ByteArrayInputStream bis = new ByteArrayInputStream("get\nsome\nfucking\nshit\n".getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        cbs.dropAbuses(bis, outStream, abuseWords);
        assertThat(outStream.toString(), is("get\nsome\n"));
    }

}