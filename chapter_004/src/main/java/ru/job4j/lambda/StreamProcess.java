package ru.job4j.lambda;

import java.util.List;

import static org.hamcrest.core.Is.is;


/**
 * Массив чисел. Оставить только четные. Каждое число возвести в квадрат. Все просуммировать.
 */
public class StreamProcess {
    public Integer calc(List<Integer> numLst) {
        return numLst.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce((x, y) -> x + y)
                .orElse(0);
    }
}
