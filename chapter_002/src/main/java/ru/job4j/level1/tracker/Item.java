package ru.job4j.level1.tracker;

import java.util.ArrayList;
import java.util.List;

class Item {
    private String      id;
    private String      name;
    private String      desc;
    private long        created;
    //private String[]    comments;
    private List<String> comments;
    
    public Item(String name, String description) {
        this.name = name;
        this.desc = description;
        //this.comments = new String[100];
        this.comments = new ArrayList<String>();
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

    public String getDescr() {
        return this.desc;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescr(String newDescr) {
        this.desc = newDescr;
    }

    public String toString() {
        StringBuffer outStr = new StringBuffer();   
        outStr.append(this.getId());
        outStr.append(" : ");
        outStr.append(this.getName());
        outStr.append(" : ");
        outStr.append(this.getDescr());
        return outStr.toString();
    }
}