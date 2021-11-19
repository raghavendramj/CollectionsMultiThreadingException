package com.java.learning.model;

public class Teacher {

    private int teacherId;
    private String name;
    private String email;

    public Teacher(int teacherId, String name, String email) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "\nTeacher{" +
                "teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
