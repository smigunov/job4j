package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean prevValMainDiag = true;
        boolean prevValCollateralDiag = true;
        int arrLength = data.length;
        boolean result = true;
        for(int i = 0; i < arrLength; i++) {
            if (i > 0) {
                if (data[i][i] != prevValMainDiag) {
                    result = false;
                    break;
                }
                if (data[arrLength - i - 1][i]!= prevValCollateralDiag) {
                    result = false;
                    break;
                }
            }
            prevValMainDiag = data[i][i];
            prevValCollateralDiag = data[arrLength - i - 1][i];
        }
        return result;
    }
}
