package ru.job4j.level1.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arr : array) {
            for (int val : arr) {
                list.add(val);
            }
        }
        return list;
    }

}
