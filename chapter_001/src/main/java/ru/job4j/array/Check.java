package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean prevVal = false;
        for (int i = 0; i < data.length; i++) {
            if (i > 0){
                result = !(prevVal ^ data[i]);
                if (!result) return result;
            }
            prevVal = data[i];
        }
        return result;
    }
}
