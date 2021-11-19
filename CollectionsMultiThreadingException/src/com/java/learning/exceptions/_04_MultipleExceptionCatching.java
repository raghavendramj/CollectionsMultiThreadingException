package com.java.learning.exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class _04_MultipleExceptionCatching {

    //Handling FileNotFoundException and IOException
    public static void readFile() {
        try {
            FileOutputStream myFileOutStream = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(myFileOutStream);

            Employee employee = new Employee(123, "Raghav", "raghav@gmail.com");
            out.writeObject(employee);

            new SimpleDateFormat().parse("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    static class Employee {

        private int employeeId;
        private String name;
        private String email;

        public Employee(int employeeId, String name, String email) {
            this.employeeId = employeeId;
            this.name = name;
            this.email = email;
        }

        public Employee() {
        }
    }
}
