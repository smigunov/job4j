package ru.job4j.level2.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicListContainer<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    public void add(E item) {
        Node<E> newNode = new Node<>(item);
        if (this.size == 0) {
            this.first = newNode;
        } else {
            newNode.prev = this.last;
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    public E get(int index) {
        if (index >= this.size) {
            throw new NoSuchElementException();
        }
        Node<E> curNode = this.first;
        if (this.size > 1) {
            for (int i = 0; i <= index; i++) {
                curNode = curNode.next;
            }
        }
        return curNode.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicListContainerIterator<E>();
    }

    private class DynamicListContainerIterator<E> implements Iterator<E> {
        int idx = 0;
        int primaryLength = DynamicListContainer.this.size;
        Node<E> curNode = (Node<E>) DynamicListContainer.this.first;    //Без cast'a не компилируется. Подскажите почему?

        @Override
        public boolean hasNext() {
            if (this.primaryLength != DynamicListContainer.this.size) {
                throw new ConcurrentModificationException();
            }
            return (this.curNode != null);
        }

        @Override
        public E next() {
            E result;
            if (this.primaryLength != DynamicListContainer.this.size) {
                throw new ConcurrentModificationException();
            }
            if (this.curNode != null) {
                result = (E) this.curNode.data;
                if (curNode.next != null) {
                    curNode = curNode.next;
                } else {
                    curNode = null;
                }

                return result;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
