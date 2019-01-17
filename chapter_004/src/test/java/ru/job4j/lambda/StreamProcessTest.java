package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamProcessTest {
    @Test
    public void test1() {
        StreamProcess sp = new StreamProcess();
        List<Integer> nums = List.of(1, 2, 3, 4);
        assertThat(sp.calc(nums), is(20));
    }

    @Test
    public void test2() {
        StreamProcess sp = new StreamProcess();
        List<Integer> nums = List.of(3, 5, 7, 9);
        assertThat(sp.calc(nums), is(0));
    }

    @Test
    public void test3() {
        StreamProcess sp = new StreamProcess();
        List<Integer> nums = List.of(2, 3, 5, 7, 9, 10);
        assertThat(sp.calc(nums), is(104));
    }

}