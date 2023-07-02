package JDBCTest;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static DAOClass da=new DAOClass();
    public static void main(String[] args)
    {
        operation();
    }

    private static void operation()
    {
        boolean status=true;
        while(status) {
            System.out.println("1. Insert Data");
            System.out.println("2. Display Data");
            System.out.println("3. Exit");
            System.out.println("Enter a Choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("1. Insert data into Student2");
                    System.out.println("2. Insert data into Subject");
                    System.out.println("3. Insert data into MarksScore");
                    System.out.println("Enter a Your Choice :");
                    int ch1=sc.nextInt();
                    switch (ch1)
                    {
                        case 1:
                            insertData1();
                            break;
                        case 2:
                            insertData2();
                            break;
                        case 3:
                            insertData3();
                            break;
                    }
                    break;
                case 2:
                    displayAllRecords();
                    break;
                case 3:
                    System.out.println("THANK U FRO VISITING !!");
                    System.out.println("HAVE A NICE DAY !!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void insertData1()
    {
        System.out.println("Enter a Name :");
        String name=sc.next();
        System.out.println("Enter a Address :");
        String add=sc.next();
        System.out.println("Enter a Class :");
        String cla=sc.next();
        DTOClass dt=new DTOClass();
        dt.setS_Name(name);
        dt.setS_Address(add);
        dt.setS_Class(cla);
        int result=da.insertData1(dt);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void insertData2()
    {
        System.out.println("Enter a Sub Name :");
        String sName=sc.next();
        DTOClass dt=new DTOClass();
        dt.setSub_Name(sName);
        int result=da.insertData2(dt);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static void insertData3()
    {
        System.out.println("Enter a Marks Id :");
        int mId=sc.nextInt();
        System.out.println("Enter a Marks :");
        double marks =sc.nextDouble();
        System.out.println("Enter a Student Ref :");
        int sRef=sc.nextInt();
        System.out.println("Enter a Subject Ref :");
        int subRef=sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setM_Id(mId);
        dt.setMarks(marks);
        dt.setS_Ref(sRef);
        dt.setSub_Ref(subRef);
        int result=da.insertData3(dt);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void displayAllRecords()
    {
        ArrayList<DTOClass> result=da.displayAllRecords();
        for(DTOClass data:result)
        {
            System.out.println(data.getRoll_No()+"\t"+data.getS_Name()+"\t"+data.getS_Address()+"\t"+data.getS_Class()+"\t"+data.getSub_Code()+"\t"+data.getSub_Name()+"\t"+data.getM_Id()+"\t"+data.getMarks()+"\t"+data.getS_Ref()+"\t"+data.getSub_Ref());
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------
}
