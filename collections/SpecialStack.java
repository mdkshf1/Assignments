package com.company;

import java.util.Scanner;

class SpecialStack
{

    int[] arr =new int[10];
    int size,min;

    SpecialStack()
    {
        size=0;
        min=Integer.MAX_VALUE;
    }

    void push(int i)
    {
        if(!isFull())
        {
            if(min>i)
                min=i;
            arr[size]=i;
            size++;
        }
        else
            System.out.println("Stack is full");
    }

    int pop()
    {

        if(!isEmpty())
        {
            size--;
            return arr[size];
        }
        else
        {
            System.out.println("Stack is Empty");
            return 0;
        }
    }

    int getMin()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty");
            return 0;
        }
        return min;
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    boolean isFull()
    {
        return size == 10;

    }

}
class thirdQues
{

    public static void main(String[] args)
    {   Scanner sc=new Scanner(System.in);
        SpecialStack obj=new SpecialStack();

        SpecialStack obj2 = new SpecialStack();

        char t;
        int x,m;
        do
        {
            System.out.println("\n1 for push element \n2 for pop element \n3 for min element\n4 for check stack is Empty or not\n5 for check stack is full or not :  ");
            x=sc.nextInt();

            switch(x)
            {  case 1: System.out.println("Enter the element : ");
                m=sc.nextInt();
            {
                obj.push(m);
                if(obj.getMin()==m)
                {
                    obj2.push(m);
                }
            }
            break;
                case 2: m= obj.pop();

                    if(m!=0)
                    {
                        System.out.println(m+" : element is deleted from the stack ");
                        if(m==obj.getMin())
                            obj2.pop();
                    }
                    break;
                case 3 : m=obj2.pop();
                { obj2.push(m);
                    System.out.println("The minimum value of a Stack : "+m);
                }
                break;
                case 4 : System.out.println("Stack is Empty : "+obj.isEmpty());
                    break;
                case 5 :  System.out.println("Stack is Full : "+obj.isFull());
                    break;
                default :  System.out.println("you choose wrong option....\n\n");

            }

            System.out.println("(y) for  menu else(n)" );
            t=sc.next().charAt(0);
        }while(t=='y');
    }

}
