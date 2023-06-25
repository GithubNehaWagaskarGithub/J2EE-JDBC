package CollableStatement;

import java.sql.*;

public class MainApp4 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{?=call minThreeNo(?,?,?)}");

            cs.setInt(2,10);
            cs.setInt(3,20);
            cs.setInt(4,30);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println("Minimum Number :"+cs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
