package ru.job4j.array;

public class Square {
    /**
     * Возвращает массив разверностью bound, каждый элемент которого сожержит квадрат индекса
     * @param bound размерность массива
     * @return массив int
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++){
            rst[i - 1] = i * i;
        }
        return rst;
    }
}