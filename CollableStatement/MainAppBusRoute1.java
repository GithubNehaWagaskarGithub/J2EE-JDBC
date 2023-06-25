package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainAppBusRoute1
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Source :");
        String source=sc.next();
        System.out.println("Enter a route No :");
        int routeNo=sc.nextInt();

        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs=con.prepareCall("{call BusRoute1(?,?)}");
            cs.setString(1,source);
            cs.setInt(2,routeNo);
            cs.execute();
            rs=cs.getResultSet();

            System.out.println("Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
