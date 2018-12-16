package ru.job4j.level1.search;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        return this.persons.stream().filter(
                person -> person.getName().contains(key)
                    || person.getAddress().contains(key)
                    || person.getPhone().contains(key)
                    || person.getSurname().contains(key)
            ).collect(Collectors.toList());
    }
}