package Demo;

import java.sql.*;

public class DisplayData2_ {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query1="select * from employee where emp_sal=(select max(emp_sal) from employee)";
        String query2="select * from employee where emp_sal=(select min(emp_sal) from employee)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(query1);
            if(rs.next())
            {
                System.out.println("Maximum Salary is :");
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }
            rs=stmt.executeQuery(query2);
            if(rs.next())
            {
                System.out.println("Minimum Salary is :");
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
