package ru.job4j.loops;


public class Paint {
    /**
     * Строит пирамиду
     * @param h  Высота пирамиды
     * @return пирамида в строке
     */
    public String drawPyramid(int height) {
        StringBuilder screen = new StringBuilder();
        for(int h = 0; h < height; h++) {
            for (int l = 0; l < (2 * height - 1); l++) {
                if ((l >= (height - 1) - h) && ((l <= (height - 1) + h))) {
                    screen.append("^");
                }
                else {
                    screen.append(" ");
                }
            }
            if (h < height - 1) {
                screen.append(System.lineSeparator());
            }
        }
        return screen.toString();
    }
}
