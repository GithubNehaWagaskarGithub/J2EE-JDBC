package ManyToManyRelationship;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static DAOClass da=new DAOClass();
    public static void main(String[] args)
    {
        operation();
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void operation()
    {
        boolean status=true;
        while (status)
        {
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Display Data");
            System.out.println("5. Exit");
            System.out.println("Enter a Choice :");
            int ch= sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("1. Insert Data in Product2 Table");
                    System.out.println("2. Insert Data in Wholesaler Table");
                    System.out.println("3. Insert Data in ProductWholesaler Table");
                    System.out.println("Enter a Choice :");
                    int ch1= sc.nextInt();
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
                    System.out.println("1. Update Data in Product2 Table");
                    System.out.println("2. Update Data in Wholesaler Table");
                    System.out.println("3. Update Data in ProductWholesaler Table");
                    System.out.println("Enter a Choice :");
                    int ch2= sc.nextInt();
                    switch (ch2)
                    {
                        case 1:
                            updateData1();
                            break;
                        case 2:
                            updateData2();
                            break;
                        case 3:
                            updateData3();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Delete Data in Product2 Table");
                    System.out.println("2. Delete Data in Wholesaler Table");
                    System.out.println("3. Delete Data in ProductWholesaler Table");
                    System.out.println("Enter a Choice :");
                    int ch3= sc.nextInt();
                    switch (ch3)
                    {
                        case 1:
                            deleteData1();
                            break;
                        case 2:
                            deleteData2();
                            break;
                        case 3:
                            deleteData3();
                            break;
                    }
                    break;
                case 4:
                    displayAllRecord();
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE!!");
                    break;
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void insertData1()
    {
        System.out.println("Enter a P_No :");
        int pNo=sc.nextInt();
        System.out.println("Enter a P_Name :");
        String pName=sc.next();
        System.out.println("Enter a P_Rate :");
        double pRate=sc.nextDouble();
        DTOClass dt=new DTOClass();
        dt.setP_No(pNo);
        dt.setP_Name(pName);
        dt.setP_Rate(pRate);
        int result=da.insertData1(dt);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    private static void insertData2()
    {
        System.out.println("Enter a W_No :");
        int wNo=sc.nextInt();
        System.out.println("Enter a W_Name :");
        String wName=sc.next();
        System.out.println("Enter a W_Address :");
        String wAdd=sc.next();
        System.out.println("Enter a W_City :");
        String wCity=sc.next();
        DTOClass dt=new DTOClass();
        dt.setW_No(wNo);
        dt.setW_Name(wName);
        dt.setW_Address(wAdd);
        dt.setW_City(wCity);
        int result=da.insertData2(dt);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static void insertData3()
    {
        System.out.println("Enter a ProductWholesaler_Id :");
        int pw_Id=sc.nextInt();
        System.out.println("Enter a P_Ref :");
        int pRef=sc.nextInt();
        System.out.println("Enter a W_Ref :");
        int wRef=sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setPW_Id(pw_Id);
        dt.setP_Ref(pRef);
        dt.setW_Ref(wRef);
        int result=da.insertData3(dt);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    private static void updateData1()
    {
        System.out.println("Enter a P_No :");
        int pNo=sc.nextInt();
        System.out.println("Enter a P_Name :");
        String pName=sc.next();
        DTOClass dt=new DTOClass();
        dt.setP_No(pNo);
        dt.setP_Name(pName);
        int result=da.updateData1(dt);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void updateData2()
    {
        System.out.println("Enter a W_No :");
        int wNo=sc.nextInt();
        System.out.println("Enter a W_Name :");
        String wName=sc.next();
        DTOClass dt=new DTOClass();
        dt.setW_No(wNo);
        dt.setW_Name(wName);
        int result=da.updateData2(dt);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private static void updateData3()
    {
        System.out.println("Enter a PW_Id :");
        int pwId=sc.nextInt();
        System.out.println("Enter a W_Ref :");
        int wRef= sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setPW_Id(pwId);
        dt.setW_Ref(wRef);
        int result=da.updateData3(dt);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    private static void deleteData1()
    {
        System.out.println("Enter a P_No :");
        int pNo= sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setP_No(pNo);
        int result=da.deleteData1(dt);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void deleteData2()
    {
        System.out.println("Enter a W_No :");
        int wNo= sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setW_No(wNo);
        int result=da.deleteData2(dt);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void deleteData3()
    {
        System.out.println("Enter a PW_Id :");
        int pwId= sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setPW_Id(pwId);
        int result=da.deleteData3(dt);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void displayAllRecord()
    {
        ArrayList<DTOClass> result=da.displayAllRecords();
        for(DTOClass data:result)
        {
            System.out.println(data.getP_No()+"\t"+data.getP_Name()+"\t"+data.getP_Rate()+"\t"+data.getW_No()+"\t"+data.getW_Name()+"\t"+data.getW_Address()+"\t"+data.getW_City()+"\t"+data.getPW_Id()+"\t"+data.getP_Ref()+"\t"+data.getW_Ref());
        }
    }
}
