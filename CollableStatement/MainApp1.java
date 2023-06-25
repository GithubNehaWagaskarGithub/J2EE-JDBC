package CollableStatement;

import java.sql.*;

public class MainApp1 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs=con.prepareCall("{?=call addTwoNumber(?,?)}");
            cs.setInt(2,10);
            cs.setInt(3,50);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.execute();
            System.out.println("Addition of two Number :"+cs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
