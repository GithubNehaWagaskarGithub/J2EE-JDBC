package Student1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static StudentOperation so=new StudentOperation();
    private static void operation()
    {
        boolean status=true;
        while(status)
        {
            System.out.println("1. Insert Data");
            System.out.println("2. Display Data");
            System.out.println("3. Display All Data");
            System.out.println("4. Check");
            System.out.println("5. Exit");
            System.out.println("Enter your Choice :");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    displayAllStudent();
                    break;
                case 4:
                    check();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

    }

    //-----------------------------------------------------------------------------------------------------------------------
    private static void addStudent()
    {
        System.out.println("Enter a Student Name :");
        String sName=sc.next();
        System.out.println("Enter a College Name :");
        String cName=sc.next();
        System.out.println("Enter a University Name :");
        String uName=sc.next();
        System.out.println("Enter a Science Marks :");
        double sci=sc.nextDouble();
        System.out.println("Enter a Java Marks :");
        double java=sc.nextDouble();
        System.out.println("Enter a Math Marks :");
        double math=sc.nextDouble();
        System.out.println("Enter a student City :");
        String city=sc.next();
        so.addData(sName,cName,uName,sci,java,math,city);
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void displayStudent()
    {
        System.out.println("Enter Student Name do you want to display data :");
        int id=sc.nextInt();
        so.displayData(id);
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void displayAllStudent()
    {
        so.displayAllData();
    }
    //-------------------------------------------------------------------------------------------------------------------------

    private static void check()
    {
//        System.out.println("Enter a College Name :");
//        String cName=sc.next();
        so.check();
    }
    //-------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        operation();
    }
}
