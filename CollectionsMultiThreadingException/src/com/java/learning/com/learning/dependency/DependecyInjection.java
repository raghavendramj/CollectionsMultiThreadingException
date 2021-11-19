package com.java.learning.com.learning.dependency;

class Address {
    private String city;
    private String state;
    private String country;
    private int pinCode;

    public Address(String city, int pinCode, String state, String country) {
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
    }
}

class Employee {
    private String name;
    private String email;
    private String phoneNumber;


    private Address address;

    public Employee(String name, String email, String phoneNumber, Address address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}

public class DependecyInjection {
    public static void main(String[] args) {
        Address address = new Address("Bangalore", 560061, "Karnataka", "India");
        Employee employee = new Employee("Raghav", "raghav@gmail.com", "9985665565", address);
        System.out.println(employee);
    }
}
