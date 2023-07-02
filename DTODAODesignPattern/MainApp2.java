package DTODAODesignPattern;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp2 {
    private static Scanner sc = new Scanner(System.in);
    private static DAOClass2 da = new DAOClass2();

    public static void main(String[] args) {
        operation();
    }

    //---------------------------------------------------------------------------------------------------------------------
    private static void operation() {
        boolean status = true;
        while (status) {
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Update Data1");
            System.out.println("4. Delete Data");
            System.out.println("5. Display Data");
            System.out.println("6. Display All Data");
            System.out.println("7. Exit");
            System.out.println("Enter a Choice");
            int ch = sc.nextInt();
            switch (ch) {
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
                    displayData();
                    break;
                case 6:
                    displayAllData1();
                    break;
                case 7:
                    System.out.println("THANKS FOR VISITING !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    break;
            }
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static void insertData() {
        System.out.println("Enter a Id :");
        int id = sc.nextInt();
        System.out.println("Enter a Name :");
        String name = sc.next();
        System.out.println("Enter a Category :");
        String category = sc.next();
        System.out.println("Enter a Price :");
        double price = sc.nextDouble();
        System.out.println("Enter a Qty :");
        int qty = sc.nextInt();
        DTOClass2 dt = new DTOClass2();
        dt.setId(id);
        dt.setName(name);
        dt.setCategory(category);
        dt.setPrice(price);
        dt.setQty(qty);
        int result = da.insertData(dt);
        if (result > 0) {
            System.out.println(result + " Data Inserted Successfully");
        } else {
            System.out.println("Data Not Inserted");
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static void updateData() {
        System.out.println("Enter a Id :");
        int id = sc.nextInt();
        System.out.println("Enter a Name :");
        String name = sc.next();
        DTOClass2 dt = new DTOClass2();
        dt.setId(id);
        dt.setName(name);
        int result = da.updateData(dt);
        if (result > 0) {
            System.out.println(result + " Data Updated Successfully");
        } else {
            System.out.println("Data Not Updated");
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static void updateData1() {
        System.out.println("Enter a Old Name :");
        String oldName = sc.next();
        System.out.println("Enter a New Name :");
        String newName = sc.next();
        DTOClass2 dt = new DTOClass2();
        //dt.setName(oldName);
        dt.setName(newName);
        int result = da.updateData1(dt, oldName);
        if (result > 0) {
            System.out.println(result + " Data updated Successfully");
        } else {
            System.out.println("Data Not Updated");
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    private static void deleteData() {
        System.out.println("Enter a Id :");
        int id = sc.nextInt();
        DTOClass2 dt = new DTOClass2();
        dt.setId(id);
        int result = da.deleteData(dt);
        if (result > 0) {
            System.out.println(result + " Data Deleted Successfully");
        } else {
            System.out.println("Data Not Deleted");
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    private static void displayData() {
        ArrayList<String> result = da.displayData();
        System.out.println("Category");
        for (String data : result) {
            System.out.println(data);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static void displayAllData1()
    {
        ArrayList<DTOClass2> result=da.displayAllData1();
        for (DTOClass2 data:result)
        {
            System.out.println(data.getId()+"\t"+data.getName()+"\t"+data.getCategory()+"\t"+data.getPrice()+"\t"+ data.getQty());
        }
    }
}

