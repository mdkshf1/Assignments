package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

class Employee
{
    String name,designation;
    int age;

    Employee(String name ,String designation,int age)
    {
        this.name=name;
        this.designation=designation;
        this.age=age;
    }


    public String toString()
    {
        return ("name : "+name+" , designation : "+designation+", age : "+age );
    }

}

class EmployeeMap
{


    public static void main(String[] args)
    {
        Map<Employee,Integer> map= new LinkedHashMap<Employee,Integer>();

        Employee e1=new Employee("Kashif","Trainee",21);
        Employee e2=new Employee("Saquib","Teacher",18);
        Employee e3=new Employee("Zaid","Doctor",24);
        Employee e4=new Employee("Azim","Engineer",23);
        Employee e5=new Employee("Hasnain","Developer",23);


        map.put(e1,10000);
        map.put(e2,20000);
        map.put(e3,30000);
        map.put(e4,35000);
        map.put(e5,40000);

        for (Employee key:map.keySet())
        {
            System.out.println(key + " : Salary :  "  +map.get(key));
        }
    }

}
