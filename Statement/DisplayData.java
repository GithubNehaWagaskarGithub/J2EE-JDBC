package Demo;

import java.sql.*;

public class DisplayData {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from employee";
        System.out.println("ID\tNAME\tSALARY");
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query);
            while (rs.next())
            {
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
