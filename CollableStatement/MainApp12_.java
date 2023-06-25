package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class MainApp12_ {
    public static void main(String[] args) {

        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call EMP2SelectData1(?)}");
            cs.execute();
            rs=cs.getResultSet();
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
