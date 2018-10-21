package ru.job4j.level2.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreTest {
    @Test
    public void testWhen1NewUser() {
        List<Store.User> prev = new ArrayList<>();
        List<Store.User> cur = new ArrayList<>();

        prev.add(new Store.User(1, "Вася"));
        cur.add(new Store.User(1, "Вася"));
        cur.add(new Store.User(2, "Петя"));
        Info diff = Store.diff(prev, cur);

        assertThat(diff.created, is(1));
        assertThat(diff.deleted, is(0));
        assertThat(diff.edited, is(0));
    }

    @Test
    public void testWhen1EditedAnd1Created() {
        List<Store.User> prev = new ArrayList<>();
        List<Store.User> cur = new ArrayList<>();

        prev.add(new Store.User(1, "Вася"));
        cur.add(new Store.User(1, "Маша"));
        cur.add(new Store.User(2, "Петя"));
        Info diff = Store.diff(prev, cur);

        assertThat(diff.created, is(1));
        assertThat(diff.deleted, is(0));
        assertThat(diff.edited, is(1));
    }

    @Test
    public void testWhen1Deleted() {
        List<Store.User> prev = new ArrayList<>();
        List<Store.User> cur = new ArrayList<>();

        cur.add(new Store.User(1, "Вася"));
        prev.add(new Store.User(1, "Вася"));
        prev.add(new Store.User(2, "Петя"));
        Info diff = Store.diff(prev, cur);

        assertThat(diff.created, is(0));
        assertThat(diff.deleted, is(1));
        assertThat(diff.edited, is(0));
    }

}