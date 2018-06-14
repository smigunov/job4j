package ru.job4j.tictactoe;
import ru.job4j.array.Check;
import ru.job4j.array.MatrixCheck;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinner(char winner) {
        boolean result = false;
        boolean[][] boolMatrix  = new boolean[this.table.length][this.table.length];
        //Проверим вертикали и горизонтали
        for(int i = 0; i < this.table.length; i++) {
            boolean[] hor =  new boolean[this.table.length];     //Горизонтали
            boolean[] vert = new boolean[this.table.length];    //Вертикали
            for (int j = 0; j < this.table.length; j++) {

                if (winner == 'X') {
                    hor[j] = this.table[i][j].hasMarkX();
                    vert[j] = this.table[j][i].hasMarkX();
                    boolMatrix[i][j] =  this.table[i][j].hasMarkX();
                }
                else if(winner == 'O') {
                    hor[j] = this.table[i][j].hasMarkO();
                    vert[j] = this.table[j][i].hasMarkO();
                    boolMatrix[i][j] =  this.table[i][j].hasMarkO();
                }
            }
            Check check = new Check();
            if (check.arrFilledByTrue(hor) || check.arrFilledByTrue(vert)) {
                result = true;
                break;
            }
        }
        //Проверим диагонали
        if(!result) {
            MatrixCheck matrixCheck = new MatrixCheck();
            if (matrixCheck.checkDiagFilledTrue(boolMatrix, MatrixCheck.enDiag.Main)) {     // Проверка главной диагонали
                result = true;
            }
            if (matrixCheck.checkDiagFilledTrue(boolMatrix, MatrixCheck.enDiag.Collateral)) {     // Проверка побочной диагонали
                result = true;
            }
        }
        return result;
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
                if ((this.table[i][j].hasMarkX() == false) && (this.table[i][j].hasMarkO() == false)) {
                    result = true;
                    break;
                }
            }
            if (result){
                break;
            }
        }
        return result;
    }
}