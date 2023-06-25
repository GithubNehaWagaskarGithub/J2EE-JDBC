package OneToManyRelationship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Id :");
        int p_Id=sc.nextInt();
        System.out.println("Enter a Name :");
        String p_Name=sc.next();
        System.out.println("Enter a Category :");
        String p_Category=sc.next();
        System.out.println("Enter a Price :");
        double p_Price=sc.nextDouble();
        System.out.println("Enter a c_Ref :");
        int c_Ref=sc.nextInt();

        Connection con=null;
        Statement stmt=null;

        String insertQuery="insert into product1 values("+p_Id+",'"+p_Name+"','"+p_Category+"',"+p_Price+","+c_Ref+")";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(insertQuery);
            System.out.println("Data Inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
