package ru.job4j.level_2.iterator;

import java.util.Iterator;

public class IteratorAnyArray<T> implements Iterator<T> {
    private T[][] values;

    private class MatrixPosition {
        public int i;
        public int j;
    }

    private MatrixPosition pos = new MatrixPosition();

    private MatrixPosition getNextPosition() {
        MatrixPosition result = new MatrixPosition();
        if (pos.j < values[pos.i].length - 1) {
            result.j = pos.j + 1;
            result.i = pos.i;
        } else if (pos.i < values.length - 1){
            result.j = 0;
            result.i = pos.i + 1;
        } else {
            result = null;
        }

        return result;
    }

    public IteratorAnyArray (T[][] values) {
        this.values = values;
        this.pos.i = 0;
        this.pos.j = 0;
    }

    @Override
    public boolean hasNext () {
        boolean result = true;
        if (this.getNextPosition() == null) {
            result = false;
        }
        return result;
    }

    @Override
    public T next () {
        T result;
        result = values[pos.i][pos.j];
        MatrixPosition nextPos = this.getNextPosition();
        if (nextPos != null) {
            this.pos = nextPos;
        }
        return result;
    }
}
