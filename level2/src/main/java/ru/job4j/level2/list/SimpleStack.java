package ru.job4j.level2.list;

public class SimpleStack<T> {
    private DynamicListContainer<T> data = new DynamicListContainer<>();

    public T poll() {
        return this.data.delete(this.data.getSize() - 1);
    }

    public void push(T value) {
        this.data.add(value);
    }
}
