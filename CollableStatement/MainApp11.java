package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Emp Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Emp Name :");
        String name=sc.next();
        System.out.println("Enter a Emp Designation :");
        String desi=sc.next();

        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call Demo3(?,?,?)}");
            cs.setInt(1,id);
            cs.setString(2,name);
            cs.setString(3,desi);
            cs.execute();
            rs=cs.getResultSet();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
