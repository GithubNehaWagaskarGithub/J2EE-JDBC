package OneToManyRelationship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Id :");
        int c_Id=sc.nextInt();
        System.out.println("Enter a Name :");
        String c_Name=sc.next();
        System.out.println("Enter a Address :");
        String c_Address=sc.next();

        Connection con=null;
        Statement stmt=null;

        String insertQuery="insert into customer values("+c_Id+",'"+c_Name+"','"+c_Address+"')";
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

