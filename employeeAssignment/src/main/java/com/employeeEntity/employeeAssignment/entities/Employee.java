package com.employeeEntity.employeeAssignment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
    @Size(min = 3,message = "the minimum characters in a name should be 3")
    private String employeeName;
    @Id
    @Positive
    private int id;
    @Positive
    @NotNull
    private int age;
    @Size(min = 2,message = "Minimum number of characters allowed are 2")
    private String location;

    public String getEmployeeName()
    {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee(String employeeName, int id, int age, String location) {
        this.employeeName = employeeName;
        this.id = id;
        this.age = age;
        this.location = location;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeName='" + employeeName + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", location='" + location + '\'' +
                '}';
    }
}
