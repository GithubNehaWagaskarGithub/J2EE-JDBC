package CollableStatement;

import java.sql.*;

public class MainApp12 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            cs= con.prepareCall("{call EMP2SelectData()}");
            cs.execute();
            rs=cs.getResultSet();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
