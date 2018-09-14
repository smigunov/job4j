package ru.job4j.level2.list;

public class CycleNode<T> {
    T value;
    CycleNode<T> next;


    public boolean hasCycle() {
        boolean result = false;
        CycleNode<T> tortoise = this;
        if (this.next != null) {
            CycleNode<T> rabbit = this.next;
            while (rabbit != tortoise && rabbit.next != null && rabbit.next.next != null && tortoise != null) {
                tortoise = tortoise.next;
                rabbit = rabbit.next.next;
                if (rabbit == tortoise) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
