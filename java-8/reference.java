import java.util.Scanner;

@FunctionalInterface
interface calc{
    int perform(int a,int b);
}
class addsub {
    int add(int a,int b)
    {
        return a+b;
    }
    int sub(int a,int b)
    {
        return a-b;
    }
    static int mul(int a,int b)
    {
        return a*b;
    }
}
public class reference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int x=sc.nextInt();
        int y=sc.nextInt();
        calc c1=new addsub()::add;
        System.out.println(c1.perform(x,y));
        calc c2=new addsub()::sub;
        System.out.println(c2.perform(x,y));
        calc c=addsub::mul;
        System.out.println(c.perform(x,y));

    }
}