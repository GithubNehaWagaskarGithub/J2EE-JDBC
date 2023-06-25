package Statement;

import java.sql.*;

public class DisplayData8 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from employee where emp_sal>30000.00";
        System.out.println("Salary is greater than 30000.00 :");
        System.out.println();
        System.out.println("Emp_Id\tEmp_Name\tEmp_Sal");
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDouble(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
