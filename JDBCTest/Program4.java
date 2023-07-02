package JDBCTest;

import java.sql.*;

public class Program4 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{?=call }");

//            cs.setInt(2,);

            cs.registerOutParameter(1,Types.DOUBLE);
            cs.execute();
            System.out.println("Simple Interest is :"+cs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
