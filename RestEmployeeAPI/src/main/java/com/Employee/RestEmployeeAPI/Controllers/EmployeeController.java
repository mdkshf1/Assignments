package com.Employee.RestEmployeeAPI.Controllers;

import com.Employee.RestEmployeeAPI.Entities.EmployeeEntity;
import com.Employee.RestEmployeeAPI.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("/show")
    public String showMessage() {
        return "WELCOME TO SPRING BOOT";
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    public ResponseEntity<List<EmployeeEntity>> showEmployees() {
        List<EmployeeEntity> list = employeeService.showEmployees();
        if (list.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(list));
        }
    }

    @GetMapping("/{empid}")
    public ResponseEntity<EmployeeEntity> showEmployee(@PathVariable("empid") int empid) {
        EmployeeEntity employee = employeeService.showEmployee(empid);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(employee));
        }
    }

    @PostMapping()
    public EmployeeEntity addEmployee(@Valid @RequestBody EmployeeEntity employee) {
        return this.employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") int empid) {
        int flag = 0;
        flag = employeeService.checkEmployee(empid);
        if (flag == 0) {

            this.employeeService.deleteEmployee(empid);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping()
    public ResponseEntity<Void> deleteAllEmployee()
    {
        List<EmployeeEntity> list = employeeService.showEmployees();
        if(list.size()!=0) {
            this.employeeService.deleteAllEmployee();
           return  ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{empid}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@Valid @RequestBody EmployeeEntity employeeEntity, @PathVariable("empid") int empid) {
        int flag = 0;
        flag = employeeService.checkEmployee(empid);
        if (flag == 0) {
            employeeService.updateEmployee(employeeEntity, empid);
            return ResponseEntity.of(Optional.of(employeeEntity));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}