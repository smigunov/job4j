package ru.job4j.level2.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] values;
    private int idx = 0;
    private int length;
    public void add(T newValue) {
        this.values[this.idx] = newValue;
        this.idx++;
    }
    public SimpleArray(int length) {
        this.values = new Object[length];
        this.length = length;
    }

    public void set(int index, T newValue) {
        this.values[index] = newValue;
    }

    public void delete(int index) {
        if (index >= 0) {
            for (int i = index + 1; i < values.length; i++) {
                this.values[i - 1] = values[i];
            }
            this.length--;
            this.idx--;
        }
    }

    public int size() {
        return this.idx;
    }

    public T get(int index) {
        T result = null;
        if (index < this.values.length) {
            result =  (T) this.values[index];
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<T>();
    }

    private class SimpleArrayIterator<T> implements Iterator<T> {
        private int idx = 0;
        @Override
        public boolean hasNext() {
            return this.idx < SimpleArray.this.length;
        }

        @Override
        public T next() {
            if (this.idx < SimpleArray.this.length) {
                this.idx++;
                return (T) SimpleArray.this.values[this.idx - 1];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
