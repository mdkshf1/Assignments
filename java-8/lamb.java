package com.company;

import java.util.Locale;
import java.util.Scanner;
@FunctionalInterface
interface maximum{
    boolean max(int x,int y);
}
@FunctionalInterface
interface increment{
    int increase(int x);
}
@FunctionalInterface
interface concat{
    String concatenation(String x,String y);
}
interface uppercase{
    String upper(String x);
}
public class lamb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int x=sc.nextInt();
        int y=sc.nextInt();
        maximum m =(a,b) ->a>b;
        System.out.println(m.max(x,y));
        System.out.println("Increment value of "+x+" is ");
        increment inc = (a)->a+1;
        System.out.println(inc.increase(x));
        System.out.println("Enter two strings");
        String q=sc.next();
        String r=sc.next();
        concat c=(a,b)->a+b;
        System.out.println("Concatenated string is ");
        System.out.println(c.concatenation(q,r));
        uppercase up = (b)-> b.toUpperCase();
        System.out.println("String in upper case is ");
        System.out.println(up.upper(r));
    }
}

