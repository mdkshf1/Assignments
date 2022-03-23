package com.employee.employeeassignment.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "teacher_type")
public class Teacher extends Person{

    @Column(name="salary",columnDefinition="DECIMAL(7,2)")
    private Double salary;
    @Column(name="dept_name",length=30)
    private String deptName;
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}