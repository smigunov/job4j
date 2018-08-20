package ru.job4j.level1.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                table[x][y] = (x + 1) * (y + 1);
            }
        }
        return table;
    }
}