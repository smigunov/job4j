package ru.job4j.level_1.comparator;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int maxSize = Math.max(left.length(), right.length());
        for (int i = 0; i < maxSize; i++) {
            if (right.length() <= i) {
                result = 1;
            } else if (left.length() <= i) {
                result = -1;
            } else if (left.charAt(i) > right.charAt(i)) {
                result = 1;
            } else if (left.charAt(i) < right.charAt(i)) {
                result = -1;
            }
            if (result != 0) {
                break;
            }
        }
        return result;
    }
}
