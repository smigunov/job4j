package ru.job4j.coffemachine;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CoffeMachineTest {
    @Test
    public void whenPrice35Value50ThenOneby10RubandOneby5Rub() {
        CoffeMachine cm = new CoffeMachine(new int[][]{{10, 1}, {1, 3}, {2, 2}, {5, 3}});
        assertThat(cm.changes(35, 50), is(new int[]{10, 5}));
    }

    @Test
    public void whenPrice35Value50ThenOneby10RubandTwoby2RubAndOneby1Rub() {
        CoffeMachine cm = new CoffeMachine(new int[][]{{10, 1}, {1, 3}, {2, 2}, {5, 0}});
        assertThat(cm.changes(35, 50), is(new int[]{10, 2, 2, 1}));
    }

    @Test
    public void whenPrice35Value50ThenOneby5RubAndFiveBy2Rub() {
        CoffeMachine cm = new CoffeMachine(new int[][]{{10, 0}, {1, 3}, {2, 10}, {5, 1}});
        assertThat(cm.changes(35, 50), is(new int[]{5, 2, 2, 2, 2, 2}));
    }
}