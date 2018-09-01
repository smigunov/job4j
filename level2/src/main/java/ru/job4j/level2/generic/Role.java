package ru.job4j.level2.generic;

public class Role extends Base {
    private String name;
    private String grade;

    public Role(String id, String name, String grade) {
        super(id);
        this.name = name;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;

    }
}
