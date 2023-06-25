package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp6 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Math Marks :");
        double math=sc.nextDouble();
        System.out.println("Enter a Physics Marks :");
        double phy=sc.nextDouble();
        System.out.println("Enter a Chemistry Marks :");
        double chemi=sc.nextDouble();
        //calculate percentage of three subjects

        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{?=call PercentageOfThreeSub(?,?,?)}");
            cs.setDouble(2,math);
            cs.setDouble(3,phy);
            cs.setDouble(4,chemi);
            cs.execute();
            cs.registerOutParameter(1, Types.VARCHAR);

            System.out.println("Student Result :"+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
