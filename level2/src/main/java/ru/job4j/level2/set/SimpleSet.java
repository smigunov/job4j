package ru.job4j.level2.set;

import ru.job4j.level2.list.DynamicArrayContainer;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E>  {
    private DynamicArrayContainer<E> arr;

    public SimpleSet(int enlargeSize) {
        arr = new DynamicArrayContainer<E>(enlargeSize);
    }

    private Boolean contains(E value) {
        for (E item : arr) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(E value) {
        if (contains(value)) {
            return false;
        }
        arr.add(value);
        return true;
    }

    public Object[] toArray() {
        return arr.toArray();
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
