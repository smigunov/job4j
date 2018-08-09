package ru.job4j.level_1.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddNewItemAndShowAll() {
        Input input = new StubInput(new String[] {"0", "testName1", "TestDescr1", "0", "testName2", "TestDescr2",  "1", "6" });
        StubOutput output = new StubOutput(new String[100]);
        StartUI ui = new StartUI(input, output);
        ui.init();
        String[] etalon = new String[] {"ITEM-1 : testName1 : TestDescr1", "ITEM-2 : testName2 : TestDescr2"};
        assertThat(output.getPhrases(), is(etalon));
    }

    @Test
    public void whenAddNewEditAndShowAll() {
        Input input = new StubInput(new String[] {"0", "testName1", "TestDescr1", "0", "testName2", "TestDescr2", "2", "ITEM-2", "NewName2", "NewDescr2", "1", "6" });
        StubOutput output = new StubOutput(new String[100]);
        StartUI ui = new StartUI(input, output);
        ui.init();
        String[] etalon = new String[] {"ITEM-1 : testName1 : TestDescr1", "ITEM-2 : NewName2 : NewDescr2"};
        assertThat(output.getPhrases(), is(etalon));
    }

    @Test
    public void whenAddNewDeleteAndShowAll() {
        Input input = new StubInput(new String[] {"0", "testName1", "TestDescr1", "0", "testName2", "TestDescr2", "3", "ITEM-2", "1", "6" });
        StubOutput output = new StubOutput(new String[100]);
        StartUI ui = new StartUI(input, output);
        ui.init();
        String[] etalon = new String[] {"ITEM-1 : testName1 : TestDescr1"};
        assertThat(output.getPhrases(), is(etalon));
    }

    @Test
    public void whenAddNewAndFindById() {
        Input input = new StubInput(new String[] {"0", "testName1", "TestDescr1", "0", "testName2", "TestDescr2", "4", "ITEM-2", "6" });
        StubOutput output = new StubOutput(new String[100]);
        StartUI ui = new StartUI(input, output);
        ui.init();
        String[] etalon = new String[] {"ITEM-2 : testName2 : TestDescr2"};
        assertThat(output.getPhrases(), is(etalon));
    }

    @Test
    public void whenAddNewAndFindByName() {
        Input input = new StubInput(new String[] {"0", "testName1", "TestDescr1", "0", "testName2", "TestDescr2", "0", "testName2", "TestDescr3", "5", "testName2", "6" });
        StubOutput output = new StubOutput(new String[100]);
        StartUI ui = new StartUI(input, output);
        ui.init();
        String[] etalon = new String[] {"ITEM-2 : testName2 : TestDescr2", "ITEM-3 : testName2 : TestDescr3"};
        assertThat(output.getPhrases(), is(etalon));
    }
}