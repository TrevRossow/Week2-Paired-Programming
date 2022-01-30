package com.techelevator;

public class Department {
    //Instance variables
    private int departmentId;
    private String name;

    //Constructor
    public Department(int departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    //Getters and Setters
    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
