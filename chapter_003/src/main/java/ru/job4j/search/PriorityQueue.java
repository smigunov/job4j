package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */

    private int getPriorityIndex(int priority) {
        int index = this.tasks.size();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getPriority() > priority) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void put(Task task) {
        this.tasks.add(getPriorityIndex(task.getPriority()), task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}