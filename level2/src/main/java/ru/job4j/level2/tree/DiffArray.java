package ru.job4j.level2.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffArray {
    public Pair<ArrayList<Integer>, ArrayList<Integer>> diff(int[] src) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Pair<ArrayList<Integer>, ArrayList<Integer>> result = new Pair(a, b);
        if (src.length > 0) {
            Arrays.sort(src);
            int sum1 = 0;
            int sum2 = 0;
            int i1 = 0;
            int i2 = 0;
            for (int i = src.length - 1; i >= 0; i--) {
                if (sum1 < sum2) {
                    a.add(src[i]);
                    sum1 += src[i];
                } else {
                    b.add(src[i]);
                    sum2 += src[i];
                }
            }
        }
        return result;
    }
}
