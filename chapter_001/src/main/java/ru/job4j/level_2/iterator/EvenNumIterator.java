package ru.job4j.level_2.iterator;

import java.util.Iterator;

public class EvenNumIterator implements Iterator<Integer> {
    private int idx;
    private Integer[] values;

    public EvenNumIterator(Integer[] values) {
        idx = -1;
        this.values = values;
    }

    private int getNext() {
        int result = -1;
        for(int i = idx + 1; i < values.length; i++) {
           if (values[i] % 2 == 0) {
               result = i;
               break;
           }
        }
        return result;
    }


    @Override
    public boolean hasNext () {
        return (getNext() >= 0);
    }

    @Override
    public Integer next () {
        idx = getNext();
        return values[idx];
    }
}
