import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Employee
{
    String Fullname;
    long salary;
    String city;
    Employee(String Fullname,long salary,String city)
    {
        this.Fullname=Fullname;
        this.salary=salary;
        this.city=city;
    }
}
public class streams {
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(10,15,20,25,30,35,40);
        al.stream().filter(n->n%2==0).forEach(System.out::println);
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee("Mohd Kashif",2000,"Nagina"));
        emp.add(new Employee("Mohd ZZ",3000,"Nagpur"));
        emp.add(new Employee("Ali",5000,"Mumbai"));
        emp.add(new Employee("Megha",4000,"New york"));
        emp.add(new Employee("Gagandeep",6000,"New Delhi"));
        emp.stream().filter(e->e.salary>5000 && e.city=="New Delhi").forEach(e-> System.out.println(e.Fullname));
    }
}
