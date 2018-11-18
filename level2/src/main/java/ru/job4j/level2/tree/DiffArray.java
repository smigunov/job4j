package ru.job4j.level2.tree;

import java.util.Arrays;

public class DiffArray {
    public static void diff(int[] a, int[] b, int[] c) {
        if (a.length > 0) {
            Arrays.sort(a);
            int sum1 = 0;
            int sum2 = 0;
            int i1 = 0;
            int i2 = 0;
            for (int i = a.length - 1; i >= 0; i--) {
                if (sum1 < sum2) {
                    b[i1] = a[i];
                    i1++;
                    sum1 += a[i];
                } else {
                    c[i2] = a[i];
                    i2++;
                    sum2 += a[i];
                }
            }
        }
    }
}
