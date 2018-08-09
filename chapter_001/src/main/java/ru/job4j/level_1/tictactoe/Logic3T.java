package ru.job4j.level_1.tictactoe;
import ru.job4j.level_1.array.Check;
import ru.job4j.level_1.array.MatrixCheck;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяет вертикальные и горизонтальные выигрышные последосательности
     * @param playerMatrix
     * @return
     */
    private boolean checkHorAndVert(boolean[][] playerMatrix) {
        boolean result = false;
        for (int i = 0; i < playerMatrix.length; i++) {
            boolean[] hor =  new boolean[playerMatrix.length];     //Горизонтали
            boolean[] vert = new boolean[playerMatrix.length];    //Вертикали
            for (int j = 0; j < playerMatrix.length; j++) {
                hor[j] = playerMatrix[i][j];
                vert[j] = playerMatrix[j][i];
            }
            Check check = new Check();
            if (check.arrFilledByTrue(hor) || check.arrFilledByTrue(vert)) {
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     * Заполяет матрицу ходов игрока
     * @param player
     * @return
     */
    private boolean[][] fillPlayerMatrix(char player) {
        boolean[][] playerMatrix  = new boolean[this.table.length][this.table.length];
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (player == 'X') {
                    playerMatrix [i][j] = this.table[i][j].hasMarkX();
                } else if (player == 'O') {
                    playerMatrix [i][j] = this.table[i][j].hasMarkO();
                }
            }
        }
        return playerMatrix;
    }

    /**
     * Проверяет выигрышние комдинации по диагоналям
     */
    private boolean checkDiagonals(boolean[][] playerMatrix) {
        boolean result = false;
        MatrixCheck matrixCheck = new MatrixCheck();
        if (matrixCheck.checkDiagFilledTrue(playerMatrix, MatrixCheck.DiagType.Main)) {     // Проверка главной диагонали
            result = true;
        }
        if (matrixCheck.checkDiagFilledTrue(playerMatrix, MatrixCheck.DiagType.Collateral)) {     // Проверка побочной диагонали
            result = true;
        }
        return result;
    }

    /**
     * Проверяет выиграл ли игрок player
     * @param player принимает значение 'X' или 'O'
     * @return
     */
    private boolean isWinner(char player) {
        boolean[][] playerMatrix = fillPlayerMatrix(player);
        return checkHorAndVert(playerMatrix) || checkDiagonals(playerMatrix);
    }

    public boolean isWinnerX() {
        return isWinner('X');
    }

    public boolean isWinnerO() {
        return isWinner('O');
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if ((!this.table[i][j].hasMarkX()) && (!this.table[i][j].hasMarkO())) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}