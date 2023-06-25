package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Choice :");
        int ch=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs=con.prepareCall("{call EMP2Data3(?)}");
            cs.setInt(1,ch);
            cs.execute();
            rs=cs.getResultSet();
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getDouble(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
