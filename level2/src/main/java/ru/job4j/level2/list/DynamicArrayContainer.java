package ru.job4j.level2.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayContainer<E> implements Iterable<E> {
    Object[] container;
    int idx = 0;
    int curLength;
    final int enlargeSize;

    public DynamicArrayContainer(int enlargeSize) {
        container = new Object[100];
        this.curLength = enlargeSize;
        this.enlargeSize = enlargeSize;
    }

    public void add(E value) {
        if (idx >= curLength - 1) {
            Object[] oldContainer = this.container;
            this.curLength += this.enlargeSize;
            container = new Object[this.curLength];
            System.arraycopy(oldContainer, 0, this.container, 0, this.curLength - this.enlargeSize);
        }
        container[idx] = value;
        idx++;
    }

    public E get(int index) {
        if (index < this.idx) {
            return (E) this.container[index];
        } else {
            throw new NoSuchElementException();
        }
    }

    public int getSize() {
        return this.idx;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayContainerIterator<E>();
    }

    private class DynamicArrayContainerIterator<E> implements Iterator<E> {
        int idx = 0;
        int primaryLength = DynamicArrayContainer.this.curLength;
        @Override
        public boolean hasNext() {
            if (this.primaryLength != DynamicArrayContainer.this.curLength) {
                throw new ConcurrentModificationException();
            }
            return (this.idx < DynamicArrayContainer.this.idx);
        }

        @Override
        public E next() {
            if (this.primaryLength != DynamicArrayContainer.this.curLength) {
                throw new ConcurrentModificationException();
            }
            if (this.idx < DynamicArrayContainer.this.idx) {
                return (E) DynamicArrayContainer.this.container[this.idx++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
