package JDBCTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Roll No :");
        int rollNo=sc.nextInt();
        System.out.println("Enter a Student Address :");
        String sAddress= sc.next();

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call JDBCTestQ(?,?)}");
            cs.setString(1,sAddress);
            cs.setInt(2,rollNo);
            cs.execute();
            System.out.println("Data Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
