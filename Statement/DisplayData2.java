package Statement;

import java.sql.*;

public class DisplayData2 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query1="select * from employee where emp_sal=(select max(emp_sal) from employee)";
        String query2="select * from employee where emp_sal=(select min(emp_sal) from employee)";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();

            rs= stmt.executeQuery(query1);
            if(rs.next())
            {
                System.out.println("Maximum salary :");
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double salary=rs.getDouble(3);
                System.out.println(id+"\t"+name+"\t"+salary);
            }

            rs= stmt.executeQuery(query2);
            if(rs.next())
            {
                System.out.println("Minimum salary :");
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double salary=rs.getDouble(3);
                System.out.println(id+"\t"+name+"\t"+salary);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
