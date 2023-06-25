package PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        Connection con=null;
       PreparedStatement stmt=null;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Stud Roll No :");
        int rollNo=sc.nextInt();
        System.out.println("Enter a Stud Name :");
        String name= sc.next();
        System.out.println("Enter a Stud Div :");
//        String div=sc.next();
        char div=sc.next().charAt(0);

        String query="insert into student values(?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9", "root", "Neha@123");
            stmt=con.prepareStatement(query);

            stmt.setInt(1,rollNo);
            stmt.setString(2,name);
            stmt.setString(3,div+"");

            int count=stmt.executeUpdate();
            System.out.println(count+" Data Inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
