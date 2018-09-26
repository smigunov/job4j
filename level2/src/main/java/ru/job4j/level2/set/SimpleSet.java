package ru.job4j.level2.set;

import ru.job4j.level2.list.DynamicArrayContainer;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E>  {
    private DynamicArrayContainer<E> dynArray;

    public SimpleSet(int enlargeSize) {
        dynArray = new DynamicArrayContainer<E>(enlargeSize);
    }

    public void add(E addingValue) {
        int insertPosition = -1;
        int size = dynArray.getSize();

        for (int i = 0; i < size; i++) {
            E curItem = dynArray.get(i);
            if (curItem.hashCode() == addingValue.hashCode()) {
                return;
            }
            if (curItem.hashCode() > addingValue.hashCode()) {
                insertPosition = i;
                break;
            }
        }

        insertPosition = (insertPosition == -1) ? size : insertPosition;
        dynArray.insert(addingValue, insertPosition);
    }

    public Object[] toArray() {
        return dynArray.toArray();
    }

    @Override
    public Iterator<E> iterator() {
        return dynArray.iterator();
    }
}
