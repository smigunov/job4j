package ru.job4j.level2.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumIterator implements Iterator<Integer> {
    private int idx;
    private Integer[] values;
    private boolean calledHasNext = false;
    private int tmpIdx = -1;

    public EvenNumIterator(Integer[] values) {
        idx = -1;
        this.values = values;
    }

    private int getNext() {
        int result = -1;
        for (int i = this.idx + 1; i < values.length; i++) {
           if (this.values[i] % 2 == 0) {
               result = i;
               break;
           }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (this.tmpIdx < 0) {
            this.tmpIdx = getNext();
        }
        return (this.tmpIdx >= 0);
    }

    @Override
    public Integer next() {
        if (this.tmpIdx >= 0) {
            this.idx = this.tmpIdx;
        } else {
            this.idx = getNext();
        }

        if (this.idx < 0) {
            throw new NoSuchElementException();
        }
        this.tmpIdx = -1;
        return values[this.idx];
    }
}
