package ru.job4j.loops;


public class Paint {

    /**
     * Дополняет строку n пробелами справа
     * @param n  количество пробелов
     */
    public static String rpad(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    /**
     * Дополняет строку n пробелами слева
     * @param n  количество пробелов
     */
    public static String lpad(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    /**
     * Повторяет входную строку n раз
     * @param n  количество повторов
     */
    public static String repeat(String s, int n) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += s;
        }
        return result;
    }

    /**
     * Строит пирамиду
     * @param h  Высота пирамиды
     * @return пирамида в строке
     */
    public String drawPyramid(int height) {
        String result = "";

        for (int i = 1; i <= height; i++)   {
            String leftPart = lpad(repeat("^", 2 * i - 1), height + i - 1);
            String rightPart = rpad(leftPart, 2 * height - 1);
            result += rightPart;
            if (i < height) {
                result += System.lineSeparator();
            }
        }

        return result;
    }
}
