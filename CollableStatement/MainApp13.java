package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a choice :");
        int ch=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call EMP2Data1(?)}");
            cs.setInt(1,ch);
            cs.execute();
            cs.getResultSet();
            System.out.println("Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
