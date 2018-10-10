package ru.job4j.level2.set;

import ru.job4j.level2.list.DynamicArrayContainer;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E>  {
    private DynamicArrayContainer<E> arr;

    public SimpleSet(int enlargeSize) {
        arr = new DynamicArrayContainer<E>(enlargeSize);
    }

    public void add(E addingValue) {
        int position = -1;
        int size = arr.getSize();
        for (int i = 0; i < size; i++) {
            E curItem = arr.get(i);
            if (curItem.hashCode() == addingValue.hashCode()) {
                return;
            }
            if (curItem.hashCode() > addingValue.hashCode()) {
                position = i;
                break;
            }
        }
        position = (position == -1) ? size : position;
        arr.insert(addingValue, position);
    }

    public Object[] toArray() {
        return arr.toArray();
    }

    @Override
    public Iterator<E> iterator() {
        return arr.iterator();
    }
}
