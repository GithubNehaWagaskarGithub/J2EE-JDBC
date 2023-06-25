package BankOperation;

import java.util.Scanner;

public class ATM_Machine
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int balance = 100000;
        int withdraw;
        int deposit;

        while (true)
        {
            System.out.println("1 : Check Balance");
            System.out.println("2 : Deposit a Money");
            System.out.println("3 : Withdraw a Money");
            System.out.println("4 : Exit the Transaction");
            System.out.println();
            System.out.print("Enter your Action do you want to perform:");

            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("Your Balance:" + balance);
                }
                break;
                case 2:
                {
                    System.out.print("Enter a money for deposit:");
                    deposit=sc.nextInt();
                    System.out.println("Your total balance is :"+(balance+=deposit));
                }
                break;
                case 3:
                {
                    System.out.print("Enter a money for withdraw :");
                    withdraw=sc.nextInt();
                    if(balance>=withdraw)
                    {
                        System.out.println("Collect your money !!");
                        System.out.println("Your Total Balance is :"+(balance-=withdraw));
                    }
                    else
                    {
                        System.out.println("No Enough money for withdraw");
                    }
                }
                break;
                case 4:
                {
                    System.out.println("Thank you for the transaction !!");
                    System.out.println("Have a Nice Day !!");
                    System.exit(0);
                }
                break;
                default:
                {
                    System.out.println("Invalid choice");
                }
                break;
            }
        }
    }
}
