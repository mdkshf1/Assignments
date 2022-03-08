package com.company;

import java.util.*;

class sumlist5
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Double> ls= new LinkedList<>();
        double temp,i,sum=0;


        for(i=0;i<5;i++)
        {
            System.out.print("Enter element : ");
            temp=sc.nextDouble();
            ls.add(temp);

        }

        ListIterator<Double> itr =ls.listIterator();

        while(itr.hasNext())
        {
            sum+=itr.next();
        }

        System.out.println("\nSum : "+sum);


    }
}