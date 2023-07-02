package JDBCTest;

import java.sql.*;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Subject Name :");
        String sName=sc.next();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String displayQuery="SELECT * FROM student2 s INNER JOIN subjects l INNER JOIN marksscore m ON s.Roll_No = m.S_Ref AND l.Sub_Code = m.Sub_Ref WHERE Sub_Name='"+sName+"'";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(displayQuery);
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6)+"\t"+rs.getInt(7)+"\t"+rs.getDouble(8)+"\t"+rs.getInt(9)+"\t"+rs.getInt(10));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
