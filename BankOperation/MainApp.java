package BankOperation;

import java.util.Scanner;

public class MainApp
{
    static Scanner sc = new Scanner(System.in);
    private static void operations()
    {
        boolean status = true;

        System.out.println("Enter the username :");
        String username = sc.next();
        System.out.println("Enter the password :");
        String password = sc.next();

        boolean result= BankOperation.LoginValidation(username,password);
        if(result==true)
        {
            System.out.println("Welcome "+BankOperation.userName);
            System.out.println(BankOperation.userName);
            System.out.println("Login Successfully!!!!");
            while(status)
            {
                System.out.println("1. DEPOSIT AMOUNT");
                System.out.println("2. WITHDRAW AMOUNT");
                System.out.println("3. CHECK BALANCE");
                System.out.println("4. ACCOUNT STATEMENT");
                System.out.println("5. TRANSFER MONEY");
                System.out.println("6. LOG OUT");
                System.out.println("7. EXIT");
                System.out.println("ENTER YOUR CHOICE");
                int ch = sc.nextInt();
                switch (ch)
                {
                    case 1:
                        System.out.println("Enter a Amount do you want to Deposited :");
                        double amt=sc.nextDouble();
                        BankOperation.DepositAmount(amt);
                        break;
                    case 2:
                        System.out.println("Enter a Amount do you want to Withdraw :");
                        double amt1=sc.nextDouble();
                        BankOperation.withdrawAmount(amt1);
                        break;
                    case 3:
                        System.out.println("ACCOUNT BALANCE IS :"+BankOperation.checkBalance());
                        break;
                    case 4:
                        BankOperation.accountStatement();
                        break;
                    case 5:
                        System.out.println("Enter a Account No you want to Transfer :");
                        int accNo=sc.nextInt();
                        System.out.println("Enter a Amount do you want to Transfer :");
                        double amt2=sc.nextDouble();
                        BankOperation.transferMoney(accNo,amt2);
                        break;
                    case 6:
                        System.out.println("LOGOUT SUCCESSFULLY");
                        System.out.println("THANKS FOR THE TRANSACTION !!");
                        System.out.println("HAVE A NICE DAY !!");
                        BankOperation.userName= null;
                        BankOperation.accountNumber=0;
                        operations();
                        break;
                    case 7:
                        status= false;
                        break;
                    default:
                        System.out.println("INSUFFICIENT DATA");
                        break;
                }
            }
        }else{
            System.out.println("INVALID LOGIN");
            operations();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        operations();
    }
}

