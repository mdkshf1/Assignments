import java.util.Scanner;
public class Xdone
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String input,finaal="",stop="xdone";
                do
                {
                        System.out.println("Enter a text");
                        input = in.next();
                        finaal=finaal + " " + input;
                }
                while(input.equals(stop)==false);
                System.out.println("Final String is as:\n"+finaal);
	}
}
