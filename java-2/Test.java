import java.util.*;
import java.io.*;


//    ***************************************  Account type which is declared as Enum type       ***********************

enum Acctype
{
    SAVINGS,CURRENT;
}



 /*                     *****************************************************************************************************************************************************

                                                         Bank class which is declared as abstract because some funcyion is common in all bank
														           but some function may differ in situation wise

												**********************************************************************************************************************			  */

abstract class Bank
{

    //     ************************************************************************************************************
    //                                required fields of a bank account holder's

    String cust_name ,bank_name,address,mo_number;
    int age ;
    char sex;
    static long Accont_nm;
    Acctype actyp;
    long balance ;
    int rt;

    //           ******************************************************************************************************************




    static
    {
        Accont_nm=3068010;
    }


    //                  *****************************************************************************************************************************

    //                     common functionality which shared by all otther sub banks

    String selectbank()
    {
        Scanner s = new Scanner(System.in);
        int i=1;

        do
        { if(i!=1)
            System.out.println("Please choose correct option");

            System.out.println("Please select your bank name : \n1 for SBI \n2 for BOI\n3 for ICICI \n ::->>  ");
            i=s.nextInt();
        }while(i<1 &&   i>3);

        switch(i)
        {
            case 1 :
                return ("SBI");


            case 2 : return ("BOI");


            case 3 : return ("ICICI");



        }
        return null;

    }

    void input()
    {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter your name : ");
        cust_name=sc.nextLine();

        System.out.print("enter your sex (M/F) : ");
        sex=sc.next().charAt(0);

        System.out.print("Enter your age : ");
        age=sc.nextInt();

        System.out.print("Enter your city: ");
        address=sc.next();

        System.out.print("Enter your mobile number : ");
        mo_number=sc.next();


        char temp;
        System.out.print("Select your Account Type (S : for Savings 		      C  :  for CURRENT  )   :  ");
        temp=sc.next().charAt(0);


        if(temp=='S')
            actyp=Acctype.SAVINGS;
        else
            actyp=Acctype.CURRENT;

        Accont_nm++;

        System.out.println("your Account Number is  :   "+Accont_nm);

        setBalance();


    }



    void deposit()

    {      Scanner s= new Scanner(System.in);
        int amount;

        System.out.println("\n\n******************************************************************************************\n");
        System.out.println("Enter the Amount you want to deposit  :  ");
        amount=s.nextInt();
        balance+=amount;
        System.out.println("the amount deposited successfully  ............................\n");



    }

    long getBalance()
    {
        return balance ;
    }

    void display()
    {

        System.out.println("\n\n\n******************************************************************************************\n");
        System.out.println("the details of a customer are as follows :  \n");
        System.out.println("Bank name : "+bank_name);
        System.out.println("\nAccount number : "+Accont_nm);
        System.out.println("\nAccount Type : "+actyp);
        System.out.println("\nCustomer name : "+cust_name);
        System.out.println("\nBalance : " + this.getBalance());
        System.out.println("\nAge : "+age);
        System.out.println("\nSex : "+sex);
        System.out.println("\nCity : "+address);
        System.out.println("\nMobile Number : "+mo_number);
        System.out.println("\nRate of interest  : "+rt+" %");



    }

    void menu(String str)
    {Scanner sc=new Scanner(System.in);

        int i;
        char tm;
        bank_name=str;
        rt=3;
        do
        {
            System.out.println("\nif you are a new user so please choose option 1 for registering yourself \n\n");
            System.out.println("\nenter your choice : \n1 for fill the details \n2 for deposit money \n3 for withdraw money \n4 for display details \n5 for check balance :   ");
            i=sc.nextInt();



            switch(i)
            {
                case 1: this.input();
                    break;
                case 2: this.deposit();
                    break;
                case 3: this.withdraw();
                    break;
                case 4: this.display();
                    break;
                case 5: System.out.println("\n******************************************************************************\n");
                    System.out.println("Balance = : "+this.getBalance());
                    break;
                default :  System.out.println("you enter wrong choice  ......................");

            }


            System.out.println("enter y to repeat menu else press n to quit ");
            tm=sc.next().charAt(0);
        }while(tm=='y');

    }


    void saveHistory()
    {File file = new File("history.txt");

        try(BufferedWriter br = new BufferedWriter(new FileWriter(file,true)))
        {
            br.write ("\n\n\n******************************************************************************************\n");
            br.write ("the details of a customer are as follows :  \n");
            br.write ("Bank name : "+bank_name);
            br.write ("\nAccount number : "+Accont_nm);
            br.write ("\nAccount Type : "+actyp);
            br.write ("\nCustomer name : "+cust_name);
            br.write ("\nBalance : " + this.getBalance());
            br.write ("\nAge : "+age);
            br.write ("\nSex : "+sex);
            br.write ("\nCity : "+address);
            br.write ("\nMobile Number : "+mo_number);
            br.write ("\nRate of interest  : "+rt+" %");

        }
        catch (IOException e)
        {
            System.out.println("unable to open file");

        }

    }



    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //           *********************************************************************************

    abstract void setBalance();
    abstract void withdraw();



}



/*                    **************************************************************************************************************************************************

					                                                     SBI class which extends class BANK

				   *****************************************************************************************************************************************************            */


class SBI extends Bank
{
    Scanner sc=new Scanner(System.in);



    void setBalance()
    {
        Scanner s= new Scanner(System.in);
        int amount=1500;

        System.out.println("\n\n\n******************************************************************************************\n");
        System.out.println("                    Welcome to State Bank of India (SBI)");
        if(actyp==Acctype.SAVINGS)
        {
            do
            {
                System.out.println("\n\n\n******************************************************************************************\n");
                if(amount<1500)
                    System.out.println("please return the amount because you enter anount less than 1500 \n");

                System.out.println("the initial min amount for opening the saving bank account is : Rs 1500  ");
                System.out.println("\nenter the amount : ");
                amount=s.nextInt();
            }while(amount<1500);

        }

        else
        {amount=5000;
            do
            {
                System.out.println("\n\n\n******************************************************************************************\n");
                if(amount<5000)
                    System.out.println("please return the amount because you enter anount less than 5000 \n");

                System.out.println("the initial min amount for opening the current bank account is : Rs 5000  ");
                System.out.println("\nenter the amount : ");
                amount=s.nextInt();
            }while(amount<5000);

        }
        balance=amount;

    }

    void withdraw()
    {
        System.out.println("\n******************************************************************************\n");
        System.out.println("enter the amount you want to withdraw  :  ");
        int amt=sc.nextInt();
        if(actyp==Acctype.SAVINGS)
        {
            if(balance-amt <1500)
                System.out.println("you have insufficient balance ");
            else
            {   balance-=amt;
                System.out.println("the amout withdrawn is : "+ amt);
            }
        }
        else
        {
            if(balance-amt <5000)
                System.out.println("you have insufficient balance ");
            else
            {   balance-=amt;
                System.out.println("the amout withdrawn is : "+ amt);
            }
        }
    }





}

/*                    **************************************************************************************************************************************************

					                                                     BOI class which extends class BANK

				   *****************************************************************************************************************************************************            */


class BOI extends Bank
{
    void setBalance()
    {
        Scanner s= new Scanner(System.in);
        int amount=2000;

        System.out.println("\n\n\n******************************************************************************************\n");
        System.out.println("                    Welcome to Bank of India (BOI)");
        if(actyp==Acctype.SAVINGS)
        {
            do
            {
                System.out.println("\n\n\n******************************************************************************************\n");
                if(amount<2000)
                    System.out.println("please return the amount because you enter anount less than 2000 \n");

                System.out.println("the initial min amount for opening the saving bank account is : Rs 2000  ");
                System.out.println("\nenter the amount : ");
                amount=s.nextInt();
            }while(amount<2000);

        }

        else
        {amount=10000;
            do
            {
                System.out.println("\n\n\n******************************************************************************************\n");
                if(amount<10000)
                    System.out.println("please return the amount because you enter anount less than 10000 \n");

                System.out.println("the initial min amount for opening the current bank account is : Rs 10000  ");
                System.out.println("\nenter the amount : ");
                amount=s.nextInt();
            }while(amount<10000);

        }
        balance=amount;

    }
    void withdraw()
    {
        {   Scanner sc=new Scanner (System.in);
            System.out.println("\n******************************************************************************\n");
            System.out.println("enter the amount you want to withdraw  :  ");
            int amt=sc.nextInt();
            if(actyp==Acctype.SAVINGS)
            {
                if(balance-amt <2000)
                    System.out.println("you have insufficient balance ");
                else
                {   balance-=amt;
                    System.out.println("the amout withdrawn is : "+ amt);
                }
            }
            else
            {
                if(balance-amt <10000)
                    System.out.println("you have insufficient balance ");
                else
                {   balance-=amt;
                    System.out.println("the amout withdrawn is : "+ amt);
                }
            }
        }

    }


}


/*                    **************************************************************************************************************************************************

					                                                     ICICI class which extends class BANK

				   *****************************************************************************************************************************************************            */


class ICICI extends Bank
{
    void setBalance()
    {
        Scanner s= new Scanner(System.in);
        int amount=3000;

        System.out.println("\n\n\n******************************************************************************************\n");
        System.out.println("                    Welcome to ICICI BANK (ICICI)");
        if(actyp==Acctype.SAVINGS)
        {
            do
            {
                System.out.println("\n\n\n******************************************************************************************\n");
                if(amount<3000)
                    System.out.println("please return the amount because you enter anount less than 3000 \n");

                System.out.println("the initial min amount for opening the saving bank account is : Rs 3000 ");
                System.out.println("\nenter the amount : ");
                amount=s.nextInt();
            }while(amount<3000);

        }

        else
        {amount=20000;
            do
            {
                System.out.println("\n\n\n******************************************************************************************\n");
                if(amount<20000)
                    System.out.println("please return the amount because you enter anount less than 20000 \n");

                System.out.println("the initial min amount for opening the current bank account is : Rs 20000  ");
                System.out.println("\nenter the amount : ");
                amount=s.nextInt();
            }while(amount<20000);

        }
        balance=amount;

    }
    void withdraw()
    {   Scanner sc=new Scanner (System.in);
        System.out.println("\n******************************************************************************\n");
        System.out.println("enter the amount you want to withdraw  :  ");
        int amt=sc.nextInt();
        if(actyp==Acctype.SAVINGS)
        {
            if(balance-amt <3000)
                System.out.println("you have insufficient balance ");
            else
            {   balance-=amt;
                System.out.println("the amout withdrawn is : "+ amt);
            }
        }
        else
        {
            if(balance-amt <20000)
                System.out.println("you have insufficient balance ");
            else
            {   balance-=amt;
                System.out.println("the amout withdrawn is : "+ amt);
            }
        }
    }




}


class Test
{


    public static void main(String[] args)
    {
        Scanner sc=new Scanner (System.in);
        char t;
        do
        {
            SBI obj = new SBI();
            String str;
            str=obj.selectbank();

            switch(str)
            {
                case "SBI" : SBI obj1=new SBI();
                    obj1.menu(str);
                    obj1.saveHistory();
                    break;
                case "BOI" : BOI obj2=new BOI();
                    obj2.menu(str);
                    obj2.saveHistory();

                    break;
                case "ICICI" : ICICI obj3=new ICICI();
                    obj3.menu(str);
                    obj3.saveHistory();

                    break;

            }

            System.out.println("press (y) to add more customers else press (n) to quit .............\n");
            t=sc.next().charAt(0);

        }while(t=='y');

    }
}
