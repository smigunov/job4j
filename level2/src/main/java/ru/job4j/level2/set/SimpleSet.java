package ru.job4j.level2.set;

import ru.job4j.level2.list.DynamicArrayContainer;

import java.util.HashSet;

public class SimpleSet<E> extends DynamicArrayContainer<E> implements Iterable<E>  {
    public SimpleSet(int enlargeSize) {
        super(enlargeSize);
    }

    private void shiftRight(int startPosition) {
        for (int i = idx - 1; i >= startPosition; i--) {
            container[i + 1] = container[i];
        }
    }

    @Override
    public void add (E addingValue) {
        int insertPosition = -1;
        for (int i = 0; i < idx; i++) {
            if (container[i].hashCode() == addingValue.hashCode()) {
                return;
            }
            if (container[i].hashCode() > addingValue.hashCode()) {
                insertPosition = i;
                break;
            }
        }
        insertPosition = (insertPosition == -1) ? idx : insertPosition;
        enlargeArrayIfNeed();
        shiftRight(insertPosition);
        container[insertPosition] = addingValue;
        modCount++;
        idx++;
    }
}
