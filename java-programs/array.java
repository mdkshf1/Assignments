import java.util.Scanner;
public class array
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[][] arr=new int[3][3];
		int i,j,sum1=0,sum2=0;
		System.out.println("Enter elements in array");
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				arr[i][j]=in.nextInt();
			}
		}
		System.out.println("The Multi Dimensional Array is:\n");
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				sum1 = sum1+arr[i][j];
				sum2 = sum2+arr[j][i];
			}
			System.out.println("Sum of "+(i+1)+" row is "+sum1);
			System.out.println("Sum of "+(j+1)+" column is "+sum2);
			sum1=0;
			sum2=0;
		}
	}
}


