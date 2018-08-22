package ru.job4j.level2.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    @Test
    public void whenAddUserThenFindItByID() {
        User usr = new User("1й", "Вася", "ДИТ");
        UserStore usrStore = new UserStore();
        usrStore.add(usr);
        User foundUser = usrStore.findById("1й");
        assertThat(foundUser.getName(), is(usr.getName()));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenStoreDoesntHaveItemWithIdThenException(){
        User usr = new User("1й", "Вася", "ДИТ");
        UserStore usrStore = new UserStore();
        usrStore.add(usr);
        User foundUser = usrStore.findById("XXX");
    }

    @Test
    public void whenReplaceThenAble2FindNewItemById() {
        UserStore usrStore = new UserStore();
        usrStore.add(new User("1й", "Вася", "ДИТ"));
        usrStore.add(new User("2й", "Клава", "Бухгалтерия"));
        usrStore.replace("1й", new User("3й", "Кузьмич", "Охрана"));
        assertThat(usrStore.findById("3й").getName(), is("Кузьмич"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenReplaceThenUnAble2FindOldItem() {
        UserStore usrStore = new UserStore();
        usrStore.add(new User("1й", "Вася", "ДИТ"));
        usrStore.add(new User("2й", "Клава", "Бухгалтерия"));
        usrStore.replace("1й", new User("3й", "Кузьмич", "Охрана"));
        User foundUser = usrStore.findById("1й");
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteThenUnAble2FindOldItem() {
        UserStore usrStore = new UserStore();
        usrStore.add(new User("1й", "Вася", "ДИТ"));
        usrStore.add(new User("2й", "Клава", "Бухгалтерия"));
        usrStore.delete("1й");
        User foundUser = usrStore.findById("1й");
    }
}