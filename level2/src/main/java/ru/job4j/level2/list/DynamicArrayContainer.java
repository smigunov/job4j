package ru.job4j.level2.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayContainer<E> implements Iterable<E> {
    protected Object[] container;
    protected int idx = 0;
    protected int curLength;
    private final int enlargeSize;
    protected int modCount = 0;

    public DynamicArrayContainer(int enlargeSize) {
        container = new Object[100];
        this.curLength = enlargeSize;
        this.enlargeSize = enlargeSize;
    }

    protected void enlargeArrayIfNeed() {
        if (idx >= curLength - 1) {
            Object[] oldContainer = this.container;
            this.curLength += this.enlargeSize;
            container = new Object[this.curLength];
            System.arraycopy(oldContainer, 0, this.container, 0, this.curLength - this.enlargeSize);
        }
    }

    public void add(E value) {
        enlargeArrayIfNeed();
        container[idx] = value;
        modCount++;
        idx++;
    }

    public Object[] toArray() {
        Object[] arr = new Object[this.idx];
        System.arraycopy(this.container, 0, arr, 0, this.idx);
        return arr;
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
        int primaryModCount = DynamicArrayContainer.this.modCount;
        @Override
        public boolean hasNext() {
            if (this.primaryModCount != DynamicArrayContainer.this.modCount) {
                throw new ConcurrentModificationException();
            }
            return (this.idx < DynamicArrayContainer.this.idx);
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) DynamicArrayContainer.this.container[this.idx++];
        }

    }
}
