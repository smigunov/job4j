package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    /**
     * Функция сдвига всей правой части в лево на 1, с определенной позиции
     *
     * @param array - массив
     * @param k - позиция, на которую начинаем двигать
     */
    public static void shiftLeft(String[] array, int k) {
        for (int i = k; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    /**
     * Функция удаления дублирующихся значений из массива
     *
     * @param array - массив
     * @return массив без дублей.
     */
    public static String[] remove(String[] array) {
        int doublesCount = 0;
        for (int i = 0; i < array.length - doublesCount; i++) {
            //for(int j = i + 1; j < array.length - doublesCount; j++) {
            int j = i + 1;
            while (j < array.length - doublesCount) {
                // Если встречается дубль, перемещаем его в конец
                if (array[i].equals(array[j])  && (j <= array.length - doublesCount - 1)) {
                    String tmp = array[i];
                    ArrayDuplicate.shiftLeft(array, j);
                    array[array.length - 1] = tmp;
                    doublesCount++;
                } else {
                    j = j + 1;
                }
            }
        }

        //Вырезаем часть массива без дублей
        return Arrays.copyOf(array, array.length - doublesCount);
    }

}
