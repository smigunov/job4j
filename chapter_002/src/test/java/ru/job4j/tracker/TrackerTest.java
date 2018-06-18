package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.beans.Transient;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void testReplace() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        String id1 = item1.getId();
        Item item2 = new Item("test2", "testDescription2");
        tracker.replace(id1, item2);
        Item[] items = new Item[100];
        items[0] = item2;
        assertThat(tracker.getAll(), is(items));
    }

    @Test
    public void testReplace2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3");
        tracker.add(item3);
        Item item4 = new Item("test4", "testDescription4");
        tracker.add(item4);
        String id = item4.getId();
        Item itemRepl = new Item("testRepl", "testDescriptionRepl");
        tracker.replace(id, itemRepl);
        assertThat(tracker.getAll()[3], is(itemRepl));
    }

    @Test
    public void testDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        String id1 = item1.getId();
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        tracker.delete(id1);
        Item[] items = new Item[100];
        items[0] = item2;
        assertThat(tracker.getAll(), is(items));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        Item item3 = new Item("test1", "testDescription2");
        tracker.add(item3);
        Item[] foundItems = tracker.findByName("test1");
        Item[] etalon = new Item[100];
        etalon[0] = item1;
        etalon[1] = item3;
        assertThat(foundItems, is(etalon));
    }

    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3");
        tracker.add(item3);
        Item foundItem = tracker.findById(item1.getId());
        assertThat(foundItem, is(item1));
    }
}

