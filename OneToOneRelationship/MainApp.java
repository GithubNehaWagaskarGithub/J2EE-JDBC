package OneToOneRelationship;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static DAOClass da=new DAOClass();
    public static void main(String[] args) {
        operations();
    }
    //------------------------------------------------------------------------------------------------------------------------------
    private static void operations()
    {
        boolean status=true;
        while(status)
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
                    System.out.println("1. Insert Data in Person Table");
                    System.out.println("2. Insert Data in Contact Table");
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
                    }
                    break;
                case 2:
                    System.out.println("1. Update Data in Person Table");
                    System.out.println("2. Update Data in Contact Table");
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
                    }
                    break;
                case 3:
                    System.out.println("1. Delete Data in Person Table");
                    System.out.println("2. Delete Data in Contact Table");
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
                    }
                    break;
                case 4:
                    System.out.println("1. Display Data of Particular Record");
                    System.out.println("2. Display Data of Particular column");
                    System.out.println("3. Display Data of all Records");
                    System.out.println("Enter a Choice :");
                    int ch4= sc.nextInt();
                    switch (ch4)
                    {
                        case 1:
                            displayDataOfParticularRecord();
                            break;
                        case 2:
                            displayDataOfParticularColumn();
                            break;
                        case 3:
                            displayAllRecords();
                    }
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------
    private static void insertData1()
    {
        System.out.println("Enter a P_Id :");
        int id=sc.nextInt();
        System.out.println("Enter a P_Name :");
        String name=sc.next();
        System.out.println("Enter a P_Add :");
        String add=sc.next();
        DTOClass dt=new DTOClass();
        dt.setP_Id(id);
        dt.setP_Name(name);
        dt.setP_Address(add);
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
        System.out.println("Enter a C_Id :");
        int cId=sc.nextInt();
        System.out.println("Enter a City :");
        String city=sc.next();
        System.out.println("Enter a Ph_No :");
        int ph_No=sc.nextInt();
        System.out.println("Enter a P_Ref");
        int ref=sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setC_Id(cId);
        dt.setCity(city);
        dt.setPh_No(ph_No);
        dt.setP_Ref(ref);
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
    private static void updateData1()
    {
        System.out.println("Enter a P_Id :");
        int id=sc.nextInt();
        System.out.println("Enter a P_Name :");
        String name=sc.next();
        DTOClass dt=new DTOClass();
        dt.setP_Id(id);
        dt.setP_Name(name);
        int result=da.updateData1(dt);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void updateData2()
    {
        System.out.println("Enter a C_Id :");
        int cId=sc.nextInt();
        System.out.println("Enter a Ph_No :");
        int ph_No=sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setC_Id(cId);
        dt.setPh_No(ph_No);
        int result=da.updateData2(dt);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------
    private static void deleteData1()
    {
        System.out.println("Enter a P_Id :");
        int id=sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setP_Id(id);
        int result=da.deleteData1(dt);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void deleteData2()
    {
        System.out.println("Enter a C_Id :");
        int id=sc.nextInt();
        DTOClass dt=new DTOClass();
        dt.setC_Id(id);
        int result=da.deleteData2(dt);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static void displayDataOfParticularRecord()
    {
        System.out.println("Enter a P_Id :");
        int id=sc.nextInt();
        ArrayList<DTOClass> result=da.displayDataOfParticularRecord(id);
        for(DTOClass data:result)
        {
            System.out.println(data.getP_Id()+"\t"+data.getP_Name()+"\t"+data.getP_Address()+"\t"+data.getC_Id()+"\t"+data.getCity()+"\t"+data.getPh_No()+"\t"+data.getP_Ref());
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void displayDataOfParticularColumn()
    {
        ArrayList<DTOClass> result=da.displayDataOfParticularColumn();
        for(DTOClass data:result)
        {
            System.out.println(data.getP_Id()+"\t"+data.getP_Name()+"\t"+data.getC_Id()+"\t"+data.getPh_No());
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static void displayAllRecords()
    {
        ArrayList<DTOClass> result=da.displayAllRecords();
        for(DTOClass data:result)
        {
            System.out.println(data.getP_Id()+"\t"+data.getP_Name()+"\t"+data.getP_Address()+"\t"+data.getC_Id()+"\t"+data.getCity()+"\t"+data.getPh_No()+"\t"+data.getP_Ref());
        }
    }
}
