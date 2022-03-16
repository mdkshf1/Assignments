package com.employeeEntity.employeeAssignment.service;

import com.employeeEntity.employeeAssignment.employeerepo.EmployeeRepo;
import com.employeeEntity.employeeAssignment.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee)
    {
        Employee emp1=new Employee();
        emp1.setEmployeeName(employee.getEmployeeName());
        emp1.setId(employee.getId());
        emp1.setAge(employee.getAge());
        emp1.setLocation(employee.getLocation());
        System.out.println(employee.toString());
        employeeRepo.save(emp1);
        return emp1;
    }
    public Employee checkEmployee(int id)
    {
        Employee emp1=employeeRepo.findById(id).get();
        return emp1;
    }
    public Employee updateEmployee(Employee employee,int id)
    {
        Employee emp1=new Employee();
        emp1.setEmployeeName(employee.getEmployeeName());
        emp1.setAge(employee.getAge());
        emp1.setLocation(employee.getLocation());
        employeeRepo.save(emp1);
        return emp1;
    }
    public void deleteEmployee(int id)
    {
        employeeRepo.deleteById(id);
    }
    public void deleteAllEmployee()
    {
        employeeRepo.deleteAll();
    }
    public List<Employee> iterEmployee()
    {
        List<Employee> list;
        list = (List<Employee>) employeeRepo.findAll();
        return list;
    }
    public long countEmployee()
    {
        return employeeRepo.count();
    }
    public List<Employee> findByName(String name)
    {
        List<Employee> list=employeeRepo.findByEmployeeName(name);
        return list;
    }
    public List<Employee> findByPrefix(String prefix)
    {
        List<Employee> list = employeeRepo.findByEmployeeNameLike(prefix);
        return list;
    }
    public List<Employee> findByAge()
    {
        List<Employee> list = employeeRepo.findByAgeBetween(28,32);
        return list;
    }
    public List<Employee> pageAndSort()
    {
        Pageable pageable = PageRequest.of(0,2,Sort.by(Sort.Direction.ASC,"age"));
        Page<Employee> employees = employeeRepo.findAll(pageable);
        int emp = employees.getTotalPages();
        System.out.println(emp);
        List<Employee> list =employees.getContent();
        return list;
    }
}