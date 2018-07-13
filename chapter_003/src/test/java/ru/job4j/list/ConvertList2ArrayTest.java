package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9},
                {10, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when6ElemntsToArrayList() {
        ConvertList2Array conv = new ConvertList2Array();
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = conv.convert(list);
        assertThat(result, is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
