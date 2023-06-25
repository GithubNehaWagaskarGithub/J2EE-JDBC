package OneToManyRelationship;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main_App1 {
    private static Scanner sc = new Scanner(System.in);
    private static UpdateData1 ud = new UpdateData1();

    public static void main(String[] args) {
        operation();
    }

    private static void operation() {
        boolean status = true;
        while (status) {
            System.out.println("1. Update Product Id :");
            System.out.println("2. Update Product Name :");
            System.out.println("3. Update Product Address :");
            System.out.println();
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    updateId();
                    break;
                case 2:
                    updateName();
                    break;
                case 3:
                    updateAddress();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void updateId() {
        System.out.println("Enter a Id :");
        int id = sc.nextInt();
        System.out.println("Enter a Set Id");
        int setId = sc.nextInt();
        ud.updateId(id, setId);
    }

    //-------------------------------------------------------------------------------------------------------
    private static void updateName() {
        System.out.println("Enter a Name :");
        String name = sc.next();
        System.out.println("Enter a Set Name");
        String setName = sc.next();
        ud.updateName(name, setName);
    }

    //-------------------------------------------------------------------------------------------------------
    private static void updateAddress() {
        System.out.println("Enter a Category :");
        String address = sc.next();
        System.out.println("Enter a Set Category");
        String setAddress = sc.next();
        ud.updateAddress(address,setAddress);
    }
}