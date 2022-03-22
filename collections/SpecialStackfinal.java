package com.company;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class SpecialStack {
    public static void main(String[] args) {
        int flag=0,min=999999;
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println("Enter the size of stack you want");
        int size=in.nextInt();
        do {
            System.out.println("Enter 1 to push an element in stack");
            System.out.println("Enter 2 to pop an element in stack");
            System.out.println("Enter 3 to check if stack is full or not");
            System.out.println("Enter 4 to check if stack is empty or not");
            System.out.println("Enter 5 to get minimum element of stack");
            System.out.println("Enter 0 to exit");
            flag = in.nextInt();
            switch (flag)
            {
                case 0:
                    break;
                case 1:
                    System.out.println("Enter the element to push");
                    int num=in.nextInt();
                    if(num<min)
                        min=num;
                    list.addLast(num);
                    System.out.println(min);
                    break;
                case 2:
                    if (list.size() != 0) {
                        System.out.println("Enter 1 to pop element");
                        System.out.println(list.getLast() + " removed");
                        list.removeLast();
                    }
                    else
                        System.out.println("Stack is empty");
                    break;
                case 3:
                    int s = list.size();
                    if(s==size-1)
                        System.out.println("strack is full");
                    else if(s>10)
                        System.out.println("stack overflowed");
                    else
                        System.out.println(size-s+" empty places left");
                    break;
                case 4:
                    s=list.size();
                    if(s==0)
                        System.out.println("stack is empty");
                    else
                        System.out.println("Stack is not empty");
                    break;
                case 5:
                    if(list.size()==0)
                        System.out.println("stack empty");
                    else
                        System.out.println("minimum element is "+min);
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
        }
        while(flag !=0);
    }
}