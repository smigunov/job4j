package ru.job4j.level_1.depart;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class DepartTest {
    @Test
    public void when3Departs() {
        Organization dp = new Organization();
        dp.addDepart("K1");
        dp.addDepart("K1\\SK1");
        dp.addDepart("K1\\SK1\\SSK1");

        assertThat(dp.getDepartsArr(true), is(new String[] {"K1", "K1\\SK1", "K1\\SK1\\SSK1"}));
    }
    @Test
    public void whenTopDepartIsNotExists() {
        Organization dp = new Organization();
        dp.addDepart("K1\\SK1");
        dp.addDepart("K1\\SK1\\SSK1");
        assertThat(dp.getDepartsArr(true), is(new String[] {"K1", "K1\\SK1", "K1\\SK1\\SSK1"}));
    }
    @Test
    public void whenMiddleDepartIsNotExists() {
        Organization dp = new Organization();
        dp.addDepart("K1");
        dp.addDepart("K1\\SK1\\SSK1");
        assertThat(dp.getDepartsArr(true), is(new String[] {"K1", "K1\\SK1", "K1\\SK1\\SSK1"}));
    }

    @Test
    public void when2TopDeparts() {
        Organization dp = new Organization();
        dp.addDepart("K1\\SK1\\SSK1");
        dp.addDepart("K2\\SK1\\SSK1");
        assertThat(dp.getDepartsArr(true), is(new String[] {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K2", "K2\\SK1", "K2\\SK1\\SSK1"}));
    }

    @Test
    public void whenDescending() {
        Organization dp = new Organization();
        dp.addDepart("K1\\SK1");
        dp.addDepart("K1\\SK2");
        dp.addDepart("K2\\SK1");
        dp.addDepart("K2\\SK2");
        assertThat(dp.getDepartsArr(false), is(new String[] {"K2", "K2\\SK2", "K2\\SK1", "K1", "K1\\SK2", "K1\\SK1"}));
    }
}