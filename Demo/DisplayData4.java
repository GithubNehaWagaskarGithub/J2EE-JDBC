package Demo;

import java.sql.*;
import java.util.Scanner;

public class DisplayData4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a UserName :");
        String username=sc.next();
        System.out.println("Enter a UserPass:");
        String pass=sc.next();

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from login where User_Name='"+username+"' and Pass='"+pass+"'";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);

            if(rs.next())
            {
                System.out.println("Login Successfully");
            }
            else {
                System.out.println("Invalid Login");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
