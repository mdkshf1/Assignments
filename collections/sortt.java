package com.company;
import java.util.*;

class Emp{
    double age;
    double salary;
    String Name;
    public Emp(double age, double salary, String Name){
        this.age=age;
        this.salary=salary;
        this.Name=Name;
    }
}
class NameComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Emp e1 = (Emp)o1;
        Emp e2 = (Emp) o2;
        return e1.Name.compareTo(e2.Name);
    }
}
class SalaryComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Emp e1 = (Emp)o1;
        Emp e2 = (Emp)o2;
        if(e1.salary == e2.salary){
            return 0;
        }
        else if(e1.salary>e2.salary){
            return 1;
        }
        else {
            return -1;
        }
    }
}
public class sortt {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new Emp(21,60000,"Me"));
        al.add(new Emp(22,40000,"Gagandeep"));
        al.add(new Emp(24,20000,"Mohd Kashif"));

        System.out.println("Sorting by name");
        Collections.sort(al, new NameComparator());
        Iterator itr = al.iterator();
        while (itr.hasNext()){
            Emp e =(Emp)itr.next();
            System.out.println(e.age + " " + e.Name + " " + e.salary);
        }


        System.out.println("Sorting by Salary");
        Collections.sort(al, new SalaryComparator());
        Iterator itr2 = al.iterator();
        while (itr2.hasNext()){
            Emp e =(Emp)itr2.next();
            System.out.println(e.age + " " + e.Name + " " + e.salary);
        }
    }
}
