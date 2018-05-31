package ru.job4j.array;

public class Turn {
    public int[] turn(int[] array) {
        int centerOfArray = (int) Math.floor(array.length / 2);
        for (int i = 0; i < centerOfArray; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }
}