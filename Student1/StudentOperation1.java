package Student1;

import java.sql.*;
import java.util.Scanner;

public class StudentOperation1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a College Name :");
        String cName=sc.next();

        Connection con=null;
        PreparedStatement pStmt=null;
        ResultSet rs=null;

        String query="select * from student1 where C_Name=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            pStmt=con.prepareStatement(query);
            pStmt.setString(1,cName);
            rs=pStmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6)+"\t"+rs.getDouble(7)+"\t"+rs.getString(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
