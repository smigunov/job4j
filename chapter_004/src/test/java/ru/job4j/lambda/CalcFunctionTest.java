package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalcFunctionTest {@Test
public void whenLinear() {
    CalcFunction l  = new CalcFunction();
    List<Double> result = new ArrayList<>();
    result = l.diapason(1,3, x -> x * 2);
    assertThat(result.toArray(), is(new Double[] {2.0, 4.0, 6.0}));
}


    @Test
    public void whenQuadr() {
        CalcFunction l  = new CalcFunction();
        List<Double> result = new ArrayList<>();
        result = l.diapason(1,3, x -> Math.pow(x, 2));
        assertThat(result.toArray(), is(new Double[] {1.0, 4.0, 9.0}));
    }

    @Test
    public void whenLog() {
        CalcFunction l  = new CalcFunction();
        List<Double> result = new ArrayList<>();
        //result = l.diapason(1,3, Math::log);
        result = l.diapason(1,3, x->{
            double r = Math.log(x);
            r = Math.round(r * 100D)/100D;
            return r;
        });
        assertThat(result.toArray(), is(new Double[] {0.0, 0.69, 1.10}));
    }
}
