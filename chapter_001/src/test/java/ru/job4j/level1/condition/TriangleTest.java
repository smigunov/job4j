package ru.job4j.level1.condition;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Migunov
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenSides3and3and42thenArea45() {
        Point a = new Point(1, 1);
        Point b = new Point(4, 4);
        Point c = new Point(4, 1);
        Triangle trg = new Triangle(a, b, c);
        double area = trg.area();
        assertThat(
                area,
                closeTo(4.5, 0.1)
        );
    }

    @Test
    public void whenSides3and4and5thenPeriod6() {
        //Triangle trg = new Triangle();
        double prd = Triangle.period(3, 4, 5);
        assertThat(
                prd,
                closeTo(6, 0.1)
        );
    }

    @Test
    public void whenSides3and4and5ThenExists() {
        Point a = new Point(1, 1);
        Point b = new Point(4, 4);
        Point c = new Point(5, 1);
        Triangle trg = new Triangle(a, b, c);
        boolean isExists = trg.exist(a.distanceTo(b), a.distanceTo(c), b.distanceTo(c));
        assertThat(
                isExists,
                is(true)
        );
    }
}
