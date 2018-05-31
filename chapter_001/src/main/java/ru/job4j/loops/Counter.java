package ru.job4j.loops;

public class Counter {
    /**
     * Возвращает сумму все четных чисел в диапазоне
     * @param start Начало диапазона
     * @param finish Окончание диапазона
     * @return Сумма всех четных чисел внутри диапазона.
     */
    public int add(int start, int finish) {
        int evenStart = start;  // Ближайшее четное к start
        int evenSum = 0;            // Сумма всех четных чисел
        if (start % 2 != 0) {
            evenStart  = start + 1;
        }

        for (int i = evenStart; i <= finish; i = i + 2) {
            evenSum = evenSum + i;
        }

        return evenSum;
    };
}
