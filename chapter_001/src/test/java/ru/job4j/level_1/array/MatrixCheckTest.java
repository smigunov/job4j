package ru.job4j.level_1.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenTruesOnMainDiag() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, true, true},
                {false, false, true}
        };
        boolean result = check.checkDiagFilledTrue(input, MatrixCheck.DiagType.Main);
        assertThat(result, is(true));
    }

    public void whenFalsesOnMainDiag() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true, false},
                {false, false, true},
                {false, false, false}
        };
        boolean result = check.checkDiagFilledTrue(input, MatrixCheck.DiagType.Main);
        assertThat(result, is(false));
    }

    @Test
    public void whenNotTruesOnMainDiag() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {false, false, true}
        };
        boolean result = check.checkDiagFilledTrue(input, MatrixCheck.DiagType.Main);
        assertThat(result, is(false));
    }

    @Test
    public void whenNotTruesOnMainDiag1() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true, false},
                {false, true, true},
                {false, false, true}
        };
        boolean result = check.checkDiagFilledTrue(input, MatrixCheck.DiagType.Main);
        assertThat(result, is(false));
    }

    @Test
    public void whenTruesOnCollateralDiag() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true, true},
                {false, true, true},
                {true, false, false}
        };
        boolean result = check.checkDiagFilledTrue(input, MatrixCheck.DiagType.Collateral);
        assertThat(result, is(true));
    }


    @Test
    public void whenNotTruesOnCollateralDiag() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.checkDiagFilledTrue(input, MatrixCheck.DiagType.Collateral);
        assertThat(result, is(false));
    }


}