package Demo;

import java.sql.*;

public class DisplayData9 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from employee";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);

            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
