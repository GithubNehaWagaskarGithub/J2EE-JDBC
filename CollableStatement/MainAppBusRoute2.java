package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainAppBusRoute2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a route No :");
        int route=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call BusRoute2(?)}");
            cs.setInt(1,route);
            cs.execute();
            rs=cs.getResultSet();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"
                        +rs.getInt(4)+"\t"+rs.getInt(5)
                        +"\t"+rs.getInt(6)+"\t"+rs.getString(7)+"\t"+rs.getInt(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
