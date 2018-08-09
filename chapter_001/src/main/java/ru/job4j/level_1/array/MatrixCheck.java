package ru.job4j.level_1.array;

public class MatrixCheck {
    /**
     * Перечислялка диагоналей: Main - главная,  Collateral - Побочная
     */
    public enum DiagType {
            Main, Collateral
    }
    /**
     * Проверяет, что главная диагональ заполненна True
     * @param data
     * @param diag Флаг диагонали. Main - главная,  Collateral - Побочная
     * @return
     */
    public boolean checkDiagFilledTrue(boolean[][] data, DiagType diag) {
        int arrLength = data.length;
        for (int i = 0; i < arrLength; i++) {
            if (diag == DiagType.Main) {      // Главная диагональ
                if (!data[i][i]) {
                    return false;
                }
            } else if (diag == DiagType.Collateral) { // Побочная диагнональ
                if (!data[arrLength - i - 1][i]) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Проверяет что главая и побочная диагонали заполненны одинаковыми значениями
     * @param data
     * @return
     */
    public boolean mono(boolean[][] data) {
        boolean prevValMainDiag = true;
        boolean prevValCollateralDiag = true;
        int arrLength = data.length;
        for (int i = 0; i < arrLength; i++) {
            if (i > 0) {
                if (data[i][i] != prevValMainDiag) {
                    return false;
                }
                if (data[arrLength - i - 1][i] != prevValCollateralDiag) {
                    return false;
                }
            }
            prevValMainDiag = data[i][i];
            prevValCollateralDiag = data[arrLength - i - 1][i];
        }
        return true;
    }


}
