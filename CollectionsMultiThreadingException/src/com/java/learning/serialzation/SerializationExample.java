package com.java.learning.serialzation;

import com.java.learning.model.Employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);) {
            Employee employee = new Employee(123, "Raghav", "raghav@gmail.com");
            out.writeObject(employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
