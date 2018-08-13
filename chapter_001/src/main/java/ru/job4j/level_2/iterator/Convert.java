package ru.job4j.level_2.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Convert {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> currentIterator;

            private void setCurrentIterator() {
                while (((currentIterator == null) || (!currentIterator.hasNext())) && (it.hasNext())) {
                    currentIterator = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                boolean result = false;
                setCurrentIterator();
                if (currentIterator != null) {
                    result = currentIterator.hasNext();
                }
                return result;
            }

            @Override
            public Integer next() {
                Integer result = 0;
                if (hasNext()) {
                    result = currentIterator.next();
                } else {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}