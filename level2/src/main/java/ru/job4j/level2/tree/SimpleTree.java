package ru.job4j.level2.tree;


import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}