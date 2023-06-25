package CollableStatement;

import java.sql.*;

public class MainApp2 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs=con.prepareCall("{?=call Demo1(?)}");
            cs.setInt(2,1);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
            System.out.println("Designation :"+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
