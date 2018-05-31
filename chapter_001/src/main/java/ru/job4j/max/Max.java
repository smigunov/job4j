package ru.job4j.max;

/**
 * @author Sergey Migunov
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Возвращает максимальное из двух чисел
     * @param first  Первое число
     * @param second  Второе число
     * @return Маквимальное из двух.
     */
    public int max(int first, int second) {

        return (first > second) ? first : second;
    }

    /**
     * Возвращает максимальное из трех чисел
     * @param first  Первое число
     * @param second  Второе число
     * @param third  Третье число
     * @return Маквимальное из двух.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }

    /**
     * Возвращает сумму двух чисел
     * @param first  Первое число
     * @param second  Второе число
     * @return Сумма двух.
     */
    public int summation(int first, int second) {
        return first + second;
    }
}
