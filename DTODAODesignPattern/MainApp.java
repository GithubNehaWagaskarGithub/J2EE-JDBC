package DTODAODesignPattern;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static DAOClass ca=new DAOClass();
    public static void main(String[] args)
    {
        operation();
    }

    private static void operation()
    {
        boolean status=true;
        while (status)
        {
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Update Data1");
            System.out.println("4. Delete Data");
            System.out.println("5. Display Data1");
            System.out.println("6. Display All Data");
            System.out.println("7. Exit");
            System.out.println("Enter your choice");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    insertData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    updateData1();
                    break;
                case 4:
                    deleteData();
                    break;
                case 5:
                    displayData1();
                    break;
                case 6:
                    displayAllData();
                    break;
                case 7:
                    System.out.println("Thanks for Visiting !!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    private static void insertData()
    {
        System.out.println("Enter a course Name :");
        String cName=sc.next();
        System.out.println("Enter a Course Fees :");
        double cFees=sc.nextDouble();
        DTOClass dtoClass=new DTOClass();
        dtoClass.setCName(cName);
        dtoClass.setCFees(cFees);
        int result=ca.insertData(dtoClass);
        if(result>0)
        {
            System.out.println("Data Inserted Successfully");
        }
        else {
            System.out.println("Data is Not Inserted");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------
    private static void updateData()
    {
        System.out.println("Enter a course Id :");
        int cId=sc.nextInt();
        System.out.println("Enter a course Name");
        String cName=sc.next();
        DTOClass dtoClass=new DTOClass();
        dtoClass.setCId(cId);
        dtoClass.setCName(cName);
        int result=ca.updateData(dtoClass);
        if(result>0)
        {
            System.out.println("Data Updated Successfully");
        }
        else {
            System.out.println("Sata not found");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------
    private static void updateData1()
    {
        System.out.println("Enter a old Course Name :");
        String oldName=sc.next();
        System.out.println("Enter a new course Name");
        String newName=sc.next();
        DTOClass dtoClass=new DTOClass();
        dtoClass.setCName(oldName);
        dtoClass.setCName(newName);
        int result=ca.updateData1(dtoClass,oldName);
        if(result>0)
        {
            System.out.println("Name Updated Successfully");
        }
        else
        {
            System.out.println("Course Name is not found");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void deleteData()
    {
        System.out.println("Enter a Course Id :");
        int cId=sc.nextInt();
        DTOClass dtoClass=new DTOClass();
        dtoClass.setCId(cId);
        int result=ca.deleteData(dtoClass);
        if(result>0)
        {
            System.out.println("Data Deleted Successfully");
        }
        else {
            System.out.println("Data Not found");
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void displayData1()
    {
        ArrayList<String> result=ca.displayData1();
        for(String data:result)
        {
            System.out.println(data);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void displayAllData()
    {
        ArrayList<DTOClass> result=ca.displayAllData();
        for (DTOClass data:result)
        {
            System.out.println(data.getCId()+"\t"+data.getCName()+"\t"+data.getCFees());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------


}
