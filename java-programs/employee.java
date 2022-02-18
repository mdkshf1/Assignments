import java.util.Scanner;
public class employee
{
	private String firstName,lastName,designation;
	int age;
	employee()
	{
		firstName="Mohd";
		lastName="Kashif";
		designation="Trainee";
		age=22;
		System.out.println("Initialised default constructor");
	}
	employee(String fname,String lname,String des,int a)
	{
		this.firstName=fname;
		this.lastName=lname;
		this.designation=des;
		this.age=a;
		System.out.println("Initialised by parameterised constructor");
	}
	employee(employee e)
	{
		this.firstName=e.firstName;
		this.lastName=e.lastName;
		this.designation=e.designation;
		this.age=e.age;
		System.out.println("Initialised by copy constructor");
	}
	public String toString()
	{
		return("the detail of employee is :\nName : "+firstName +" "+lastName+"\nage :"+age+"\ndesignation : "+designation);
	}
	String getMethod()
	{
		return (firstName+" "+lastName);
	}
	void setMethod(String fname,String lname)
	{
		this.firstName=fname;
		this.lastName=lname;
	}
	public static void main(String[] args)
	{
		System.out.println("********************");
		employee e1=new employee();
		System.out.println("\n"+e1);
		System.out.println("**********************");
		employee e2=new employee("kashif","mohd","trainer",20);
		System.out.println("\n"+e2);
		System.out.println("**********************");
		employee e3=new employee(e1);
		System.out.println("\n"+e3);
		System.out.println("******************");
		Scanner sc=new Scanner(System.in);
		String fname,lname;
		System.out.println("Enter first name");
		fname=sc.next();
		System.out.println("Enter last name");
		lname=sc.next();
		e1.setMethod(fname,lname);
		System.out.println("The values assignm by the help of setmethod and displaying by the help of getmethod");
		System.out.println("Employee name is : "+e1.getMethod());
	}
}
