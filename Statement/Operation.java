package Demo;

import java.sql.*;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Connection con=null;
        PreparedStatement pStmt=null;
        ResultSet rs=null;

        String query="select * from course";

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            pStmt=con.prepareStatement(query);
            rs= pStmt.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
