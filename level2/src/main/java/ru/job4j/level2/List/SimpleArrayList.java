package ru.job4j.level2.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> {
    private int size = 0;
    private Node<E> last;

    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.prev = this.last;
        this.last = newLink;

        this.size++;
    }
    //Метод удаления первого элемент в списке.
    public void delete() {
        Node<E> curItem = this.last;
        Node<E> prevItem = this.last;
        while(curItem.prev != null) {
            prevItem = curItem;
            curItem = curItem.prev;
        }
        if (prevItem != null) {
            prevItem.prev = null;
            this.size = this.size - 1;
        }
    }

    public Object[] toArray() {
        int idx = 0;
        Object[] arr = new Object[this.size];
        for (Node<E> curNode = this.last; curNode != null; curNode = curNode.prev) {
            arr[this.size - idx - 1] = curNode.data;
            idx++;
        }
        return arr;
    }

    public E get(int index) {
        if(index > this.size - 1) {
            throw new NoSuchElementException();
        }
        Node<E> result = this.last;
        for (int i = 0; i < (this.size - 1) - index; i++) {
            result = result.prev;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<T> {
        T data;
        Node<T> prev;

        Node(T date) {
            this.data = date;
        }
    }

}
