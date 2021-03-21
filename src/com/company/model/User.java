package com.company.model;



public class User {

    //todo автогенератор id

    public Integer id;

    public String name;

    public String fam;

    public String otch;

    public User(Integer id,String name, String fam, String otch) {
        this.id = id;
        this.name = name;
        this.fam = fam;
        this.otch = otch;
    }

    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    @Override
    //jsonToString()
    public String toString() {
        return "{\"User\":{"
                + "                        \"name\":\"" + name + "\""
                + ",                         \"fam\":\"" + fam + "\""
                + ",                         \"otch\":\"" + otch + "\""
                + "}}";
    }

}
