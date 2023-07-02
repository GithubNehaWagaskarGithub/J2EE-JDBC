package DTODAODesignPattern;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp1 {
    private static Scanner sc=new Scanner(System.in);
    private static DAOClass1 d1=new DAOClass1();
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
            System.out.println("3. Delete Data");
            System.out.println("4. Display Data");
            System.out.println("5. Exit");
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
                    deleteData();
                    break;
                case 4:
                    displayData();
                    break;
                case 5:
                    System.out.println("THANK U FOR VISITING");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static void insertData()
    {
        System.out.println("Enter a Roll No :");
        int rollNo= sc.nextInt();
        System.out.println("Enter a Name :");
        String name= sc.next();
        System.out.println("Enter a Div :");
        char div=sc.next().charAt(0);
        DTOClass1 dto=new DTOClass1();
        dto.setStud_Roll_No(rollNo);
        dto.setStud_Name(name);
        dto.setStud_Div(div);
        int result=d1.insertData(dto);
        if(result>0)
        {
            System.out.println(result+" Data Inserted Successfully");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void updateData()
    {
        System.out.println("Enter a RollNo :");
        int rollN0=sc.nextInt();
        System.out.println("Enter a Name :");
        String name=sc.next();
        DTOClass1 dto=new DTOClass1();
        dto.setStud_Roll_No(rollN0);
        dto.setStud_Name(name);
        int result=d1.updateData(dto);
        if(result>0)
        {
            System.out.println(result+" Data Updated Successfully");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static void deleteData()
    {
        System.out.println("Enter a Roll No :");
        int rollNo=sc.nextInt();
        DTOClass1 dto=new DTOClass1();
        dto.setStud_Roll_No(rollNo);
        int result=d1.deleteData(dto);
        if(result>0)
        {
            System.out.println(result+" Data Deleted Successfully");
        }
        else {
            System.out.println("Data Not deleted");
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static void displayData()
    {
        ArrayList<DTOClass1> result=d1.displayData();
        System.out.println("RollNo\tName\tDiv");
        for (DTOClass1 data:result)
        {
            System.out.println(data.getStud_Roll_No()+"\t"+data.getStud_Name()+"\t"+ data.getStud_Div());
        }
    }
}
