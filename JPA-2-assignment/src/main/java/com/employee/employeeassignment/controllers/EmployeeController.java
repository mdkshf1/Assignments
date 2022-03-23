package com.employee.employeeassignment.controllers;

import com.employee.employeeassignment.employeeservice.EmployeeService;
import com.employee.employeeassignment.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/partialdata")
    public List<Object> findpartialdata()
    {
        List<Object> list = this.employeeService.findPartialData();
        return list;
    }
    @PutMapping("/update")
    public List<Employee> updateSalary(@RequestBody int salary)
    {
        List<Employee> list = this.employeeService.updateSalary(salary);
        return list;
    }
    @DeleteMapping("/minsalary")
    public List<Employee> minSalary()
    {
        List<Employee> list = this.employeeService.minSalary();
        return list;
    }
    @GetMapping("/findsingh")
    public List<Object> findSingh()
    {
        List<Object> list = this.employeeService.findSingh();
        return list;
    }
    @DeleteMapping("deleteage")
    public List<Employee> deleteAge(@RequestBody int age)
    {
        List<Employee> list = this.employeeService.deleteAge(age);
        return list;
    }
}
