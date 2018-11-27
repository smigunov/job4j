package ru.job4j.level2.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class DiffArray {
    ArrayList<Integer> a;
    ArrayList<Integer> b;
    public DiffArray() {
        a = new ArrayList<Integer>();
        b = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getA() {
        return this.a;
    }

    public ArrayList<Integer> getB() {
        return this.b;
    }

    public static DiffArray diff(int[] src) {
        DiffArray diffArr = new DiffArray();

        if (src.length > 0) {
            Arrays.sort(src);
            int sum1 = 0;
            int sum2 = 0;
            int i1 = 0;
            int i2 = 0;
            for (int i = src.length - 1; i >= 0; i--) {
                if (sum1 < sum2) {
                    diffArr.a.add(src[i]);
                    sum1 += src[i];
                } else {
                    diffArr.b.add(src[i]);
                    sum2 += src[i];
                }
            }
        }

        return diffArr;
    }
}
