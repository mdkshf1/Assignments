interface one{
    default void display(){
        System.out.println("this is interface one");
    }
}
interface two extends one
{
    default void display()
    {
        one.super.display();
        System.out.println("this is interface two");
    }
}
interface three extends one,two
{
    default void display()
    {
        two.super.display();
        System.out.println("this is interface three");
    }
}
class xyz implements three{
     public void display()
    {
        three.super.display();
        System.out.println("this is a child class");
    }
}
public class multipleinheritence extends xyz{
    public static void main(String[] args) {
        xyz x=new xyz();
        x.display();
    }
}
