import java.util.Scanner;
public class circle
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int s;
		double r;
		System.out.println("********MENU******");
		System.out.println("1. Area of Circle");
		System.out.println("2. Circumference of circle");
		System.out.println("3. Exit");
		s = in.nextInt();
	        switch(s)
	        {
		case 1:
		System.out.println("Enter radius of circle");
		r=in.nextDouble();
 		double area=(22*r*r)/7;
		System.out.println("Area of circle : "+area);
		break;
		case 2:
		System.out.println("Enter radius of circle");
		r=in.nextDouble();
		double circ =(2*22*r)/7;
		System.out.println("Circumference of circle : "+circ);
		break;
		case 3:
		break;
		default:
		System.out.println("Wrong choice");
		}
	}
}
