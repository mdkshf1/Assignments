package com.employeeEntity.employeeAssignment.controllers;

import com.employeeEntity.employeeAssignment.entities.Employee;
import com.employeeEntity.employeeAssignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody Employee employee)
    {
        return this.employeeService.addEmployee(employee);
    }
    @PutMapping("update/{id}")
    public Employee updateEmployee(@Valid @PathVariable("id") int id,@RequestBody Employee employee)
    {
        Employee emp = this.employeeService.checkEmployee(id);
        if(emp!=null)
        {
            return employeeService.updateEmployee(employee,id);
        }
        else
        {
            return emp;
        }
    }
    @DeleteMapping("{id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable("id") int id)
    {
        Employee emp = this.employeeService.checkEmployee(id);
        if(emp!=null)
        {
            employeeService.deleteEmployee(id);
            return "Employee Deleted";
        }
        else
            return "Employee not found";
    }
    @DeleteMapping("/all")
    @ResponseBody
    public String deleteAllEmployee()
    {
        employeeService.deleteAllEmployee();
        return "All Employees deleted";
    }
    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable ("id") int id)
    {
        Employee emp=null;
        emp=employeeService.checkEmployee(id);
        if(emp!=null)
            return emp;
        else
            return null;
    }
    @GetMapping("/")
    public List<Employee> getAllEmployee()
    {
           List<Employee> list=new ArrayList<Employee>();
           list=this.employeeService.iterEmployee();
           return list;
    }
    @GetMapping("/count")
    public long countEmployees()
    {
        long n=employeeService.countEmployee();
        return n;
    }
    @GetMapping("/find/{name}")
    public List<Employee> findByName(@PathVariable ("name") String name)
    {
        List<Employee> list = this.employeeService.findByName(name);
        return list;
    }
    @GetMapping("/findchar/{prefix}")
    public List<Employee> findByPrefix(@PathVariable("prefix") char prefix)
    {
        String pr=String.valueOf(prefix);
        pr=pr+"%";
        List<Employee> list = this.employeeService.findByPrefix(pr);
        return list;
    }
    @GetMapping("/findage")
    public List<Employee> findByAge()
    {
        List<Employee> list = employeeService.findByAge();
        return list;
    }
    @GetMapping("/sort")
    public List<Employee> pageAndSort()
    {
        List<Employee> list = employeeService.pageAndSort();
        return list;
    }
}