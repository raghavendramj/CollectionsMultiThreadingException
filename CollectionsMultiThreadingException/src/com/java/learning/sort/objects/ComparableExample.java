package com.java.learning.sort.objects;

import com.java.learning.model.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableExample {

    public static void main(String[] args) {
        Student student1 = new Student(12, "Pointing", "pointing@gmail.com");
        Student student2 = new Student(13, "Gilchrist", "Gilchrist@gmail.com");
        Student student3 = new Student(14, "Hayden", "hayden@gmail.com");
        Student student4 = new Student(15, "McGrath", "mcgrath@gmail.com");

        List<Student> students = Arrays.asList(student3, student1, student4, student2);
        System.out.println("Before Sorting :- " + students);
        Collections.sort(students);
        System.out.println("After Sorting :- " + students);
    }
}
