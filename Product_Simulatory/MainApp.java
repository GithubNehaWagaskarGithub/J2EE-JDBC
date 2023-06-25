package Product_Simulatory;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainApp {
    private static Scanner sc=new Scanner(System.in);
    private static Product_Operations po=new Product_Operations();
    public static void main(String[] args) {
        operations();
    }
    private static void operations()
    {
        boolean status=true;
        while(status)
        {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display all Product");
            System.out.println("5. Exit");
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayAllProduct();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
    private static void addProduct(){
        System.out.println("Enter  Product Id");
        int id=sc.nextInt();
        System.out.println("Enter Product Name :");
        String name=sc.next();
        System.out.println("Enter Product Category :");
        String category=sc.next();
        System.out.println("Enter Product Sub Category :");
        String sub_category=sc.next();
        System.out.println("Enter Product Price :");
        Double price=sc.nextDouble();
        System.out.println("Enter Product Qty :");
        int qty=sc.nextInt();
        po.addData(id,name,category,sub_category,price,qty);
    }
    //--------------------------------------------------------------------------------------------
    private  static void updateProduct(){
        boolean status = true;
        while(status){

            System.out.println("1.UPDATE PRODUCT  ID");
            System.out.println("2.UPDATE PRODUCT NAME");
            System.out.println("3.UPDATE PRODUCT CATEGORY");
            System.out.println("4.UPDATE PRODUCT SUB_CATEGORY");
            System.out.println("5.UPDATE PRODUCT PRICE");
            System.out.println("6.UPDATE PRODUCT QTY");
            System.out.println("7.EXIT");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    updateId();
                    break;
                case 2:
                    updateName();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    updateSubCategory();
                    break;
                case 5:
                    updatePrice();
                    break;
                case 6 :
                    updateQty();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
    private  static void updateId(){
        System.out.println("Enter Product id you want to update");
        int id = sc.nextInt();
        System.out.println("Enter Product id you want to update");
        int setId = sc.nextInt();
        po.update_Id(id,setId);
    }
    private  static void updateName(){
        System.out.println("Enter Product id you want to update");
        int id = sc.nextInt();
        System.out.println("Enter Product name you want to update");
        String setName = sc.next();
        po.update_Name(id,setName);
    }
    private  static void updateCategory(){
        System.out.println("Enter Product Category you want to update");
        int id = sc.nextInt();
        System.out.println("Enter Product Category you want to update");
        String setCategory = sc.next();
        po.update_Category(id,setCategory);
    }
    private  static void updateSubCategory(){
        System.out.println("Enter Product SubCategory you want to update");
        int id = sc.nextInt();
        System.out.println("Enter Product SubCategory you want to update");
        String setSubCategory = sc.next();
        po.update_SubCategory(id,setSubCategory);
    }
    private  static void updatePrice(){
        System.out.println("Enter Product price  you want to update");
        int id = sc.nextInt();
        System.out.println("Enter Product price  you want to update");
        Double setPrice = sc.nextDouble();
        po.update_Price(id,setPrice);
    }
    private  static void updateQty(){
        System.out.println("Enter Product qty you want to update");
        int id = sc.nextInt();
        System.out.println("Enter Product qty you want to update");
        int setQty = sc.nextInt();
        po.update_qty(id,setQty);
    }
    //--------------------------------------------------------------------------------------------
    private static void deleteProduct()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        po.deleteData(id);
    }
    //--------------------------------------------------------------------------------------------
    private static void displayAllProduct()
    {
        po.displayAllData();
    }
}
