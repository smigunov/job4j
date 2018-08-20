package ru.job4j.level1.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[cells][rows];
        int row = 0;
        int col = 0;
        for (Integer val : list) {
            array[col][row] = val;
            if ((row + 1) % rows == 0) {
                row = 0;
                col++;
            } else {
                row++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] ints : list) {
            for (int val : ints) {
                result.add(val);
            }
        }
        return result;
    }
}
