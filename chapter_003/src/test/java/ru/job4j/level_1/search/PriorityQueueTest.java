package ru.job4j.level_1.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middle2", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenMiddlePriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }
    @Test
    public void whenMiddlePriority2() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 2));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middle", 8));

        Task result = queue.take();
        assertThat(result.getPriority(), is(2));
    }

    @Test
    public void whenMiddlePriority3() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 2));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middle", 8));
        queue.put(new Task("megaUrgent", 1));

        Task result = queue.take();
        assertThat(result.getPriority(), is(1));
    }
}