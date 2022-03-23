package com.employee.employeeassignment;

import com.employee.employeeassignment.employeerepo.EmployeeRepo;
import com.employee.employeeassignment.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeassignmentApplication.class, args);
	}

}
