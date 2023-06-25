package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Name :");
        String name=sc.next();
        System.out.println("Enter a Designation :");
        String desi=sc.next();
        System.out.println("Enter a Salary");
        double sal=sc.nextDouble();
        System.out.println("Enter a Employee Ref :");
        int empRef=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call InsertData(?,?,?,?)}");
            cs.setString(1,name);
            cs.setString(2,desi);
            cs.setDouble(3,sal);
            cs.setInt(4,empRef);
            cs.execute();
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
