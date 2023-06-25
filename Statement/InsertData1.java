package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData1 {
    public static void main(String[] args) {//insert a data by end user using scanner class
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Name :");
        String name=sc.next();
        System.out.println("Enter a salary :");
        double sal=sc.nextDouble();

        String query="insert into employee values("+id+",'"+name+"',"+sal+")";

        Connection con=null;
        Statement stmt=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            int count=con.createStatement().executeUpdate(query);
            System.out.println(count+" data inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
