package Demo;

import java.sql.*;

public class DisplayData7 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select distinct emp_sal from employee";
        System.out.println("Distinct salary is :");
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getDouble(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
