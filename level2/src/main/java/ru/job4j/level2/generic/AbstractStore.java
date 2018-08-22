package ru.job4j.level2.generic;

import java.util.NoSuchElementException;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> items = new SimpleArray<T>(100);

    @Override
    public void add (T model) {
        items.add(model);
    }

    private int getIndexById(String id) {
        int result = -1;

        for (int i = 0; i < items.size(); i++) {
            String itemId = items.get(i).getId();
            if (id.equals(itemId)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean replace (String id, T model) {
        int idx = this.getIndexById(id);
        boolean result = false;
        if (idx >= 0) {
            items.set(idx, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete (String id) {
        int idx = this.getIndexById(id);
        boolean result = false;
        if (idx >= 0) {
            items.delete(idx);
            result = true;
        }
        return result;
    }

    @Override
    public T findById (String id) {
        T result;
        int idx = this.getIndexById(id);
        if (idx >= 0) {
            result = items.get(idx);
        } else {
            throw new NoSuchElementException();
        }

        return result;
    }
}
