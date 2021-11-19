package com.java.learning.exceptions;

import com.java.learning.model.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class _06_Try_With_Resources {

    public static void readFile() {

        try (
                FileInputStream inputStream = new FileInputStream("employee.ser");
                ObjectInputStream in = new ObjectInputStream(inputStream);
        ) {
            Employee employee = new Employee(123, "Raghav", "raghav@gmail.com");
            System.out.println(employee);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile();
    }
}
