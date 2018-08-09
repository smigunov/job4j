package ru.job4j.level_1.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void testReplace() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        item2.setId(item1.getId());
        tracker.replace(item2);
        List<Item> items = new ArrayList<Item>();
        items.add(item2);
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
        Item itemRepl = new Item("testRepl", "testDescriptionRepl");
        itemRepl.setId(item4.getId());
        tracker.replace(itemRepl);
        assertThat(tracker.getAll().get(3), is(itemRepl));
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
        List<Item> items = new ArrayList<Item>();
        items.add(item2);
        assertThat(tracker.getAll(), is(items));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        Item item3 = new Item("test1", "testDescription3");
        tracker.add(item3);
        List<Item> foundItems = tracker.findByName("test1");
        /*Item[] etalon = new Item[2];
        etalon[0] = item1;
        etalon[1] = item3;
        System.out.println("0 = " + etalon[0].getDescr());
        System.out.println("1 = " + etalon[1].getDescr());*/
        assertThat(foundItems.get(0).getName(), is("test1"));
        assertThat(foundItems.get(1).getName(), is("test1"));
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

