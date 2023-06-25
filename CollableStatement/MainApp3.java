package CollableStatement;

import java.sql.*;

public class MainApp3 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{?=call maxThreeNo(?,?,?)}");

            cs.setInt(2,90);
            cs.setInt(3,80);
            cs.setInt(4,70);

            cs.registerOutParameter(1,Types.INTEGER);
            cs.execute();
            System.out.println("Maximum Number :"+cs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
