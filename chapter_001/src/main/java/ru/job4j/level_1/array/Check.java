package ru.job4j.level_1.array;

public class Check {

    /**
     * Проверяет, что логический массив заполнен True
     * @param data
     * @return
     */
    public boolean arrFilledByTrue(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (!data[i]) {
                result  = false;
                break;
            }
        }
        return result;
    }

    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean prevVal = false;

        for (int i = 0; i < data.length; i++) {
            if (i > 0) {
                result = (prevVal == data[i]);
                if (!result) {
                    break;
                }
            }
            prevVal = data[i];
        }
        return result;
    }
}
