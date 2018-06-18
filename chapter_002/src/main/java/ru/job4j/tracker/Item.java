package ru.job4j.tracker;
class Item {
    private String      id;
    private String      name;
    private String      desc;
    private long        created;
    private String[]    comments;
    
    public Item(String name, String description) {
        this.name = name;
        this.desc = desc;
        this.comments = new String[100];
        this.created = System.currentTimeMillis();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}