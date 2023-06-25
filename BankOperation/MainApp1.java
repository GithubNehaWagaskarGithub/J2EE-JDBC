package BankOperation;

import java.util.Scanner;

public class MainApp1
{
    static Scanner sc = new Scanner(System.in);
    private static void operations()
    {
        boolean status = true;

        System.out.println("Enter the username :");
        String username = sc.next();
        System.out.println("Enter the password :");
        String password = sc.next();

        boolean result= BankOperation1.LoginValidation(username,password);
        if(result==true)
        {
            System.out.println("Login Successfully!!!!");
            while(status)
            {
                System.out.println("1.DEPOSIT AMOUNT");
                System.out.println("2.WITHDRAW AMOUNT");
                System.out.println("3.CHECK BALANCE");
                System.out.println("4.ACCOUNT STATEMENT");
                System.out.println("5.LOG OUT");
                System.out.println("6.EXIT");
                System.out.println("ENTER YOUR CHOICE");
                int ch = sc.nextInt();
                switch (ch)
                {
                    case 1:
                        System.out.println("Enter the amount you want to deposit");
                        double depo = sc.nextDouble();
                        BankOperation1.depositAmount(depo);
                        //BankOperation1.accountTransactions();
                        break;
                    case 2:
                        System.out.println("Enter the amount you want to Withdraw");
                        double with = sc.nextDouble();
                        BankOperation1.withdrawAmount(with);
                        //BankOperation1.accountTransactions();
                        break;
                    case 3:
                        BankOperation1.checkBalance();
                        break;
                    case 4:
                        BankOperation1.accountStatement();
                        break;
                    case 5:
                        System.out.println("LogOut Successfully");
                        System.out.println("Thank You for the Transaction !!");
                        System.out.println("Have a Nice Day !!");
                        BankOperation1.userName= null;
                        BankOperation1.accountNumber=0;
                        operations();
                        break;
                    case 6:
                        status= false;
                        break;
                    default:
                        System.out.println("Insufficient Data");
                        break;
                }
            }
        }else{
                System.out.println("Invalid Login");
                operations();
        }
    }
//-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        operations();
    }
}
