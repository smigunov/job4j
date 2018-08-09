package ru.job4j.level_1.depart;

import java.util.*;

public class Depart implements Comparable<Depart>{
    private String code = new String();
    private TreeMap<String, Depart> subDeparts = new TreeMap<>();
    private class SplitCodes {
        public String topCode;
        public String subCodes;

        public SplitCodes(String code) {
            int idx = code.indexOf("\\");
            if (idx < 0) {
                this.topCode = code;
            } else {
                this.topCode = code.substring(0, idx);
                this.subCodes = code.substring(idx + 1);
            }
        }
    }

    @Override
    public int compareTo (Depart o) {
        return this.code.compareTo(o.getCode());
    }

    public String getCode() {
        return this.code;
    }

    public Map<String, Depart> getSubDeparts () {
        return subDeparts;
    }

    public Depart(String code) {
        this.code = code;
    }

    public void addSubDepart(String subDepartsCode) {
        SplitCodes splCodes = new SplitCodes(subDepartsCode);
        Depart subDepart = subDeparts.get(splCodes.topCode);
        if (subDepart == null) {
            subDepart = new Depart(splCodes.topCode);
            this.subDeparts.put(subDepart.getCode(), subDepart);
        }

        if (splCodes.subCodes != null) {
            subDepart.addSubDepart(splCodes.subCodes);
        }
    }

    public List<String> getSorted(boolean asc) {
        ArrayList<String> result = new ArrayList<>();
        if (this.code != "Top") {
            result.add(this.code);
        }

        Set<String> keys;
        if (asc) {
            keys = this.subDeparts.keySet();
        } else {
            keys = this.subDeparts.descendingKeySet();
        }
        for (String key : keys) {
            List<String> subDepartsCodes = this.subDeparts.get(key).getSorted(asc);
            for (int i = 0; i < subDepartsCodes.size(); i++) {
                String newCode = subDepartsCodes.get(i);
                if (this.code != "Top") {
                    newCode = this.code.concat("\\").concat(newCode);
                }
                subDepartsCodes.set(i, newCode);
            }
            result.addAll(subDepartsCodes);
        }
        return result;
    }
}
