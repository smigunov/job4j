package ru.job4j.array;

public class ArrayDuplicate {

    /**
     * Функция сдвига всей правой части в лево на 1, с определенной позиции
     *
     * @param array - массив
     * @param k - позиция, на которую начинаем двигать
     * @return сдвинутый массив.
     */
    public String[] remove(String[] array) {
        public void shiftLeft( int k) {
            for (int i = k; i < array.length - 1; i++ ) {
                array[i] = array[i + 1];
            }
        }

        public boolean

        int doublesCount = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {

                }
            }
            String tmp = array[i];
            shiftLeft(i);
            array[array.length - 1] = tmp;
            doublesCount++;
        }
    }

}
