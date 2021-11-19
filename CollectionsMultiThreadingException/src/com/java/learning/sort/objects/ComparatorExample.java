package com.java.learning.sort.objects;

import com.java.learning.model.Teacher;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TeacherIdComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher teacher1, Teacher teacher2) {
        if (teacher1.getTeacherId() > teacher2.getTeacherId())
            return 1;
        else if (teacher1.getTeacherId() < teacher2.getTeacherId())
            return -1;
        else
            return 0;
    }
}

class TeacherNameComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher teacher1, Teacher teacher2) {
        return teacher1.getName().compareTo(teacher2.getName());
    }
}

public class ComparatorExample {

    public static void main(String[] args) {
        Teacher Teacher1 = new Teacher(12, "Fedrer", "Fedrer@gmail.com");
        Teacher Teacher2 = new Teacher(13, "Jokovick", "Jokovick@gmail.com");
        Teacher Teacher3 = new Teacher(14, "Nadal", "Nadal@gmail.com");
        Teacher Teacher4 = new Teacher(15, "Sharapova", "Sharapova@gmail.com");
        Teacher Teacher5 = new Teacher(07, "Williams", "Williams@gmail.com");
        Teacher Teacher6 = new Teacher(21, "Adam", "Adam@gmail.com");
        List<Teacher> teachers = Arrays.asList(Teacher5, Teacher2, Teacher3, Teacher4, Teacher1, Teacher6);

        System.out.println("Before Sorting :- " + teachers);

        //Collections.sort(teachers, new TeacherIdComparator());
        //System.out.println("ID based sorting - Before Sorting :- " + teachers);

        //Collections.sort(teachers, new TeacherNameComparator());
        //System.out.println("Name based sorting - Before Sorting :- " + teachers);

        Collections.sort(teachers, Comparator.comparing(Teacher::getName));
        System.out.println("\n\n Using Java 8 :: Name based sorting - Before Sorting :- " + teachers);

        Collections.sort(teachers, Comparator.comparing(Teacher::getTeacherId));
        System.out.println("\nUsing Java 8 :: ID based sorting - Before Sorting :- " + teachers);
    }
}
