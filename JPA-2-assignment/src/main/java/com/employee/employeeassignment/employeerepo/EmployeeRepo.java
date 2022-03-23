package com.employee.employeeassignment.employeerepo;

import com.employee.employeeassignment.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
   @Query("select e.firstName, e.lastName, e.salary from Employee e where e.salary>(select AVG(salary) from Employee)")
     List<Object> findPartialData(Sort sort);
   @Query("select AVG(salary) from Employee")
    double avgsalary();
   @Modifying
   @Transactional
   @Query("update Employee set salary =:newsalary where salary <:avgsalary")
   void updateSalary(@Param("newsalary") int newsalary,@Param("avgsalary") int avgsalary);
   @Query("select MIN(salary) from Employee")
    double minsalary();
   @Modifying
   @Transactional
   @Query("delete from Employee where salary=:minsalary")
    void deleteEmployee(@Param("minsalary") int minsalary);
   @Query(value = "select emp_id,emp_first_name,emp_age from employee where emp_last_name LIKE 'singh'",nativeQuery = true)
    List<Object> findsingh();
   @Modifying
   @Transactional
    @Query(value = "delete from employee where emp_age>=:givenage",nativeQuery = true)
    void deleteage(@Param("givenage") int givenage);
  }