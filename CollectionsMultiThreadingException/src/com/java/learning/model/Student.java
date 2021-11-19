package com.java.learning.model;

public class Student implements Comparable<Student> {

    private int studentId;
    private String name;
    private String email;

    public Student(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    public Student() {
    }

    @Override
    public int compareTo(Student inComingStudent) {

        if (this.studentId > inComingStudent.studentId)
            return 1;
        else if (this.studentId < inComingStudent.studentId)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "\n Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
