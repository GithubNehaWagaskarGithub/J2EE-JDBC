package Demo;

import java.sql.*;

public class DisplayData6 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select emp_Name,emp_sal from employee";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"="+rs.getDouble(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
