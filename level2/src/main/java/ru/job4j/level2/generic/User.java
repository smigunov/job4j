package ru.job4j.level2.generic;

public class User extends Base {
    private String name;
    private String department;

    public User(String id, String name, String department) {
        super(id);
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }


}
