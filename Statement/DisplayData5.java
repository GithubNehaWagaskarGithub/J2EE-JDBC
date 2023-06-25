package Statement;

import java.sql.*;
import java.util.Scanner;

public class DisplayData5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Name :");
        String name=sc.next();

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="Select * from employee where emp_Name='"+name+"'";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query);
            if(rs.next())
            {
                System.out.println("Record is Present");
            }
            else{
                System.out.println("Record is not Present");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
