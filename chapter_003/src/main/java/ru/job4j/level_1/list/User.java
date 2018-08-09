package ru.job4j.level_1.list;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String city;
    private int age;

    public User(int id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }
}
