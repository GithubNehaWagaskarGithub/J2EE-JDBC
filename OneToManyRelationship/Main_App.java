package OneToManyRelationship;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main_App {
    private static Scanner sc = new Scanner(System.in);
    private static UpdateData ud=new UpdateData();

    public static void main(String[] args) 
    {
        operation();
    }
    private static void operation()
    {
        boolean status=true;
        while(status)
        {
            System.out.println("1. Update Product Id :");
            System.out.println("2. Update Product Name :");
            System.out.println("3. Update Product Category :");
            System.out.println("4. Update Product Price");
            System.out.println("5. Update Product C_Ref");
            System.out.println();
            int ch=sc.nextInt();
            switch(ch)
            {
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
                    updatePrice();
                    break;
                case 5:
                    updateC_Ref();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
    
    private static void updateId()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Set Id");
        int setId=sc.nextInt();
        ud.updateId(id,setId);
    }
    //-------------------------------------------------------------------------------------------------------
    private static void updateName()
    {
        System.out.println("Enter a Name :");
        String  name=sc.next();
        System.out.println("Enter a Set Name");
        String  setName=sc.next();
        ud.updateName(name,setName);
    }
    //-------------------------------------------------------------------------------------------------------
    private static void updateCategory()
    {
        System.out.println("Enter a Category :");
        String  category=sc.next();
        System.out.println("Enter a Set Category");
        String  setCategory=sc.next();
        ud.updateCategory(category,setCategory);
    }
    //---------------------------------------------------------------------------------------------------------
    private static void updatePrice()
    {
        System.out.println("Enter a Price :");
        double price=sc.nextDouble();
        System.out.println("Enter a Set Price");
        double setPrice=sc.nextDouble();
        ud.updatePrice(price,setPrice);
    }
    //-----------------------------------------------------------------------------------------------------------
    private static void updateC_Ref()
    {
        System.out.println("Enter a C_Ref :");
        int ref=sc.nextInt();
        System.out.println("Enter a Set C_Ref");
        int setC_Ref=sc.nextInt();
        ud.updateC_Ref(ref,setC_Ref);
    }

}

