package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number 1 :");
        int a=sc.nextInt();
        System.out.println("Enter a Number 2 :");
        int b=sc.nextInt();
        System.out.println("Enter a Choice :");
        int ch=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{?=call Calculator(?,?,?)}");
            cs.setInt(2,a);
            cs.setInt(3,b);
            cs.setInt(4,ch);
            cs.execute();
            cs.registerOutParameter(1, Types.DOUBLE);
            System.out.println("Calculation is :"+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
