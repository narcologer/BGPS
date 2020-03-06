package com.example.demo.model;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String secondname;
    private int study_group_id;

    public Student(int id, String surname, String name, String secondname, int groupid) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondname = secondname;
        this.study_group_id = study_group_id;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSecondname() {
        return secondname;
    }

    public int getStudy_group_id() {
        return study_group_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setStudy_group_id(int study_group_id) {
        this.study_group_id = study_group_id;
    }
}