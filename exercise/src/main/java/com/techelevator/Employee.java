package com.techelevator;

public class Employee {
    //Instance variables
    private long employeeId;
    private String firstName, lastName, email, hireDate;
    private double salary;
    private Department department;
    private final double STARTING_SALARY = 60000;

    //Constructors
    public Employee(long employeeId, String firstName, String lastName, String email,
                    Department department, String hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.hireDate = hireDate;
        salary = STARTING_SALARY;
    }

    public Employee() {
    }

    //Method & Derived Property
    private String getFullName() {
        return lastName + ", " + firstName;
    }

    public void raiseSalary(double percent) {
        double raisePercent = percent / 100;
        double raiseValue = salary * raisePercent;
        salary += raiseValue;
    }

    //Getters and setters
    
}
