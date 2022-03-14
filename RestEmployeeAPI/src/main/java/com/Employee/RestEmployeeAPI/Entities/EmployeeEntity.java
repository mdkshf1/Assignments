package com.Employee.RestEmployeeAPI.Entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EmployeeEntity {
    @NotNull
    @Positive
    private int EmployeeId;
    @Size(min = 3 ,message = "Not enough characters minimum length is 3")
    private String name;
    @Positive
    @NotNull
    private int age;

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EmployeeEntity(int employeeId, String name, int age) {
        EmployeeId = employeeId;
        this.name = name;
        this.age = age;
    }

    public EmployeeEntity() {
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "EmployeeId=" + EmployeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

