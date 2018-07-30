package ru.job4j.depart;

import java.util.List;

public class Organization {
    Depart topDepart = new Depart("Top");
    public void addDepart(String dpCode) {
        topDepart.addSubDepart(dpCode);
    }
    public String[] getDepartsArr(boolean asc) {
        List<String> lst = topDepart.getSorted(asc);
        String[] result = lst.toArray(new String[lst.size()]);
        return result;
    }
}
