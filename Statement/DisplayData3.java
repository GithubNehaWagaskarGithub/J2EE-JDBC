package Demo;

import java.sql.*;
import java.util.Scanner;

public class DisplayData3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a UserName :");
        String username=sc.next();
        System.out.println("Enter a UserPass:");
        String pass=sc.next();

        boolean status=false;

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from login";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);

            while (rs.next())
            {
                if(rs.getString(1).equals(username) && rs.getString(2).equals(pass))
                {
                    System.out.println("Login Successfully");
                    status=true;
                }
            }
            if(status==false)
            {
                System.out.println("Invalid Login");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
