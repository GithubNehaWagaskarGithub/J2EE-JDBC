package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp8__ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number :");
        int num=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{?=call DividedBy7OrNot(?)}");
            cs.setInt(2,num);
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.execute();
            System.out.println("Number Is :"+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
