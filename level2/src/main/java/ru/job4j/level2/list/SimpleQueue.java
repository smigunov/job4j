package ru.job4j.level2.list;

public class SimpleQueue<T> {
    private DynamicListContainer<T> data = new DynamicListContainer<>();

    public T poll() {
        return this.data.delete(0);
    }

    public void push(T value) {
        this.data.add(value);
    }
}
