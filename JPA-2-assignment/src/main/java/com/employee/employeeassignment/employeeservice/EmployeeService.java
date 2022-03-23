package com.employee.employeeassignment.employeeservice;

import com.employee.employeeassignment.employeerepo.EmployeeRepo;
import com.employee.employeeassignment.entities.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Object> findPartialData() {
        List<Object> list = employeeRepo.findPartialData(Sort.by(Sort.Order.by("age"), new Sort.Order(Sort.Direction.DESC, "salary")));
        return list;
    }

    public List<Employee> updateSalary(int salary) {
        int avgsalary = (int) employeeRepo.avgsalary();
        System.out.println(avgsalary);
        /*List<Employee> list = (List<Employee>) employeeRepo.findAll();
        list = list.stream().filter(emp -> {
            if (emp.getSalary() < avgsalary) {
                emp.setSalary(salary);
            }
            return true;
        }).collect(Collectors.toList());*/
        employeeRepo.updateSalary(salary,avgsalary);
        List<Employee> list = (List<Employee>) employeeRepo.findAll();
        return list;
    }

    public List<Employee> minSalary() {
        int minsalary = (int) employeeRepo.minsalary();
        System.out.println(minsalary);
        employeeRepo.deleteEmployee(minsalary);
        List<Employee> list = (List<Employee>) employeeRepo.findAll();
        return list;
    }
    public List<Object> findSingh()
    {
        List<Object> list = employeeRepo.findsingh();
        return list;
    }
    public List<Employee> deleteAge(int age)
    {
        employeeRepo.deleteage(age);
        List<Employee> list = (List<Employee>) employeeRepo.findAll();
        return list;
    }
}