package ru.job4j.tracker;

import org.junit.Test;

import ru.job4j.tracker.ConsoleOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

public class NStartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    private void showMenu(StringBuffer sb) {
        sb.append("0. Add new Item").append(System.lineSeparator())
        .append("1. Show all items").append(System.lineSeparator())
        .append("2. Edit item").append(System.lineSeparator())
        .append("3. Delete item").append(System.lineSeparator())
        .append("4. Find item by Id").append(System.lineSeparator())
        .append("5. Find items by name").append(System.lineSeparator())
        .append("6. Exit Program").append(System.lineSeparator());
    }

    @Test
    public void whenAddNewItemAndShowAll() {
        Input input = new StubInput(new String[] {"0", "testName1", "TestDescr1", "1", "6" });
        Output output = new ConsoleOutput();
        StartUI ui = new StartUI(input, output);
        ui.init();
        StringBuffer sb = new StringBuffer();
        showMenu(sb);
        showMenu(sb);
        sb.append("ITEM-1 : testName1 : TestDescr1").append(System.lineSeparator());
        showMenu(sb);
        String etalon = sb.toString();
        assertThat(out.toString(), is(etalon));
    }
}