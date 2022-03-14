package com.Employee.RestEmployeeAPI.Services;

import com.Employee.RestEmployeeAPI.Entities.EmployeeEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {
    private static List<EmployeeEntity> EmpList = new ArrayList<>();

    static {
        EmpList.add(new EmployeeEntity(101, "Kashif", 21));
        EmpList.add(new EmployeeEntity(102, "Saquib", 22));
        EmpList.add(new EmployeeEntity(103, "Gagan", 23));
        EmpList.add(new EmployeeEntity(104, "Faizan", 24));
        EmpList.add(new EmployeeEntity(105, "Shah", 25));
    }

    public List<EmployeeEntity> showEmployees() {
        return EmpList;
    }

    public EmployeeEntity showEmployee(int empid) {
        EmployeeEntity employee = null;
        try {
            employee = EmpList.stream().filter(emp -> emp.getEmployeeId() == empid).findFirst().get();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        EmpList.add(employee);
        return employee;
    }

    public int checkEmployee(int empid) {
        for (EmployeeEntity emp : EmpList
        ) {
            if (emp.getEmployeeId() == empid) {
                System.out.println("1");
                return 0;
            }
        }
        System.out.println("0");
    return 1;
    }

    public void deleteEmployee(int empid) {
        EmpList = EmpList.stream().filter(emp -> emp.getEmployeeId() != empid).collect(Collectors.toList());
    }
    public int deleteAllEmployee()
    {
        EmpList.clear();
        return 0;
    }

    public void updateEmployee(EmployeeEntity employee, int empid) {
        EmpList = EmpList.stream().map(b -> {
            if (b.getEmployeeId() == empid) {
                b.setName(employee.getName());
                b.setAge(employee.getAge());
            }
            return b;
        }).collect(Collectors.toList());
    }
}