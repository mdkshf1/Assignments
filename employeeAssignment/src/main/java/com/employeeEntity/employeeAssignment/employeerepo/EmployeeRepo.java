package com.employeeEntity.employeeAssignment.employeerepo;

import com.employeeEntity.employeeAssignment.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {

     List<Employee> findByEmployeeName(String employeeName);
     List<Employee> findByEmployeeNameLike(String employeName);
     List<Employee> findByAgeBetween(int age1,int age2);
    }
