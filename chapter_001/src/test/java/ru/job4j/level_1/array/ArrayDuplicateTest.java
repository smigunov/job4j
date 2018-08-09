package ru.job4j.level_1.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ArrayDuplicateTest {
    @Test
    public void testDuplicate1() {
        String[] input = new String[] {"Привет", "Мир", "Привет", "Небо", "Привет", "Солнце", "Солнце", "Небо"};
        String[] result = ArrayDuplicate.remove(input);
        String[] expected = new String[] {"Привет", "Мир", "Небо", "Солнце"};
        assertThat(result, is(expected));
    }

    @Test
    public void testDuplicate2() {
        String[] input = new String[] {"Привет", "Привет", "Привет", "Мир", "Привет", "Небо", "Привет", "Солнце", "Солнце", "Небо", "Звезды"};
        String[] result = ArrayDuplicate.remove(input);
        String[] expected = new String[] {"Привет", "Мир", "Небо", "Солнце", "Звезды"};
        assertThat(result, is(expected));
    }
}
