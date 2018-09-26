package ru.job4j.level2.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int bucketsCount = 16;
    private int itemsCount = 0;
    private final float loadFactor = 0.75f;
    private Node[] buckets;
    private int modCount = 0;

    public SimpleHashMap() {
        buckets = new Node[this.bucketsCount];
    }

    public SimpleHashMap(int bucketsCount) {
        this.bucketsCount = bucketsCount;
        buckets = new Node[this.bucketsCount];
    }

    private int getIndex(K key) {
        int hash = key == null ? 0 : key.hashCode();
        return hash % this.bucketsCount;
    }

    private void resizeIfNeed() {
        if (this.itemsCount >= bucketsCount * loadFactor) {
            this.bucketsCount *= 2;
            Node<K, V>[] newArr = new Node[this.bucketsCount];
            for (Node<K, V> node : this.buckets) {
                if (node != null) {
                    int idx = getIndex(node.key);
                    newArr[idx] = node;
                }
            }

            this.buckets = newArr;
        }
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        int idx = getIndex(key);
        if (buckets[idx] != null) {
            result = false;
        } else {
            itemsCount++;
            Node<K, V> node = new Node(key, value);
            buckets[idx] = node;
            resizeIfNeed();
            modCount++;
        }

        return result;
    }

    public V get(K key) {
        V result = null;
        int idx = getIndex(key);
        if (this.buckets[idx] != null) {
            result = (V) this.buckets[idx].value;
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int idx = getIndex(key);
        if (this.buckets[idx] != null) {
            this.buckets[idx] = null;
            result = true;
            itemsCount--;
            modCount++;
        }
        return result;
    }

    private class Node<K, V> {
        K key;
        V value;
        public Node(K key, V value) {
            Node.this.key = key;
            Node.this.value = value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new SimpleHashMapIterator();
    }

    private class SimpleHashMapIterator implements Iterator<V> {
        private int idx = 0;
        private int nextIdx = -1;
        private int primaryModCount = SimpleHashMap.this.modCount;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (this.nextIdx > this.idx) {
                result = true;
            } else {
                for (int i = idx; i < SimpleHashMap.this.bucketsCount; i++) {
                    if (SimpleHashMap.this.buckets[i] != null) {
                        result = true;
                        nextIdx = i;
                        break;
                    }
                }
            }
            return result;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.idx = this.nextIdx + 1;
            return (V) SimpleHashMap.this.buckets[this.nextIdx].value;
        }
    }

}
