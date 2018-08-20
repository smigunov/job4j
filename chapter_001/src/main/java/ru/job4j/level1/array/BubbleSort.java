package ru.job4j.level1.array;

public class BubbleSort {
    /**
     * Метод сортировки массива методом пузырька
     *
     * @param arr входной массив значений для сортировки
     * @return отсортированный массив значений.
     */
    public static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapping = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapping = true;
                }
            }
            if (!swapping) {
                break;
            }
        }
        return arr;
    }
}
