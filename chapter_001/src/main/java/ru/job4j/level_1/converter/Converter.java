package ru.job4j.level_1.converter;
/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */

    private int rateEUR = 70;
    private int rateUSD = 60;


    public int rubleToEuro(int value) {
        return value / rateEUR;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллоры
     */
    public int rubleToDollar(int value) {
        return value / rateUSD;
    }
}
