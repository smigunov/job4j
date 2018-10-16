package ru.job4j.level2.tree;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isPresent()) {
            result = false; // Привязываемая нода уже есть в дереве.
        } else {
            try {
                findBy(parent).get().add(new Node<E>(child));
                result = true;
            } catch (NoSuchElementException e) {
                result = false;
            }
        }
        return result;
    }
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Stack<Integer> lvlIndexStack = new Stack<>();
            private Node<E> curNode = Tree.this.root;

            @Override
            public boolean hasNext() {
                return (curNode != null);
            }

            private Node<E> getNodeByStack() {
                Node<E> iNode = Tree.this.root;
                for (Integer i : lvlIndexStack) {
                    iNode = iNode.leaves().get(i);
                }
                return iNode;
            }

            @Override
            public E next() {
                E result = curNode.getValue();
                Node<E> nextNode = null;

                if (curNode.leaves().size() > 0) {  // Если у текущей ноды есть дети, то опускаемся глубже
                    curNode = curNode.leaves().get(0);
                    lvlIndexStack.push(0);
                } else {    // Если детей нет, то поднимаемся наверх и идем к следующему ребенку.
                    while ((nextNode == null)) {
                        try {
                            Integer idx = lvlIndexStack.pop();
                            Node<E> parentNode = getNodeByStack();
                            if (idx + 1 < parentNode.leaves().size()) {
                                // Если есть брат, то берем его
                                lvlIndexStack.push(idx + 1);
                                nextNode = parentNode.leaves().get(idx + 1);
                            }
                        } catch (EmptyStackException e) {
                            break;
                        }
                    }
                    curNode = nextNode;
                }
                return result;
            }
        };
    }
}
