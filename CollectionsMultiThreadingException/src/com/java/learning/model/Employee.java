package com.java.learning.model;


import java.io.Serializable;

public class Employee implements Serializable {
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
