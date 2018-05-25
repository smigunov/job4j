package ru.job4j.loops;

public class Factorial {

    /**
     * Возвращает факториал
     * @return Факториал(n)
     */
    public int calc(int n) {
        int result = 1;
        for(int i = 2; i <= n; i++){
            result = result * i;
        }

        return result;
    };
}
