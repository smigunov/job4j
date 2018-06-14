package ru.job4j.tictactoe;
import ru.job4j.array.Check;
import ru.job4j.array.MatrixCheck;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяет вертикальные и горизонтальные выигрышные последосательности
     * @param player
     * @return
     */
    public boolean checkHorAndVert(char player) {
        boolean result = false;
        for (int i = 0; i < this.table.length; i++) {
            boolean[] hor =  new boolean[this.table.length];     //Горизонтали
            boolean[] vert = new boolean[this.table.length];    //Вертикали
            for (int j = 0; j < this.table.length; j++) {
                if (player == 'X') {
                    hor[j] = this.table[i][j].hasMarkX();
                    vert[j] = this.table[j][i].hasMarkX();
                    //boolMatrix[i][j] =  this.table[i][j].hasMarkX();
                } else if (player == 'O') {
                    hor[j] = this.table[i][j].hasMarkO();
                    vert[j] = this.table[j][i].hasMarkO();
                    //boolMatrix[i][j] =  this.table[i][j].hasMarkO();
                }
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
    public boolean checkDiagonals(char player) {
        boolean result = false;
        boolean[][] playerMatrix = fillPlayerMatrix(player);
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
    public boolean isWinner(char player) {
        return checkHorAndVert(player) || checkDiagonals(player);
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