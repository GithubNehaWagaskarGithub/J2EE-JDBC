package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number :");
        int num=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs=con.prepareCall("{?=call DivideBy(?)}");
            cs.setInt(2,num);
            cs.execute();
            cs.registerOutParameter(1, Types.VARCHAR);
            System.out.println("Number is :"+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}