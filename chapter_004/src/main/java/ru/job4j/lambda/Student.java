package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    private String name;
    private int scope;

    public Student (String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return this.name;
    }

    public int getScope() {
        return this.scope;
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((s1, s2) -> (s2.getScope() - s1.getScope()))
                .takeWhile(x -> x.getScope() > bound)
                .collect(Collectors.toList());
    }
}
