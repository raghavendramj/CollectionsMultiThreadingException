package com.java.learning.serialzation;

import com.java.learning.model.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationExample {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("employee.ser");
             ObjectInputStream in = new ObjectInputStream(inputStream)) {
            Employee employee = (Employee) in.readObject();
            System.out.println("Employee Received is :- " + employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
