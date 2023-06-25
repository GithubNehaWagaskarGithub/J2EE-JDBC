package OneToManyRelationship;

import java.sql.*;

public class MainApp1 {
    public static void main(String[] args) {
        //DISPLAY ALL THE RECORDS OF CUSTOMER & PRODUCT TABLES
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String query1="select * from customer c inner join product1 p on p.c_Ref=c.c_Id";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query1);
            System.out.println("C_Id\tC_Name\tC_Address");
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getDouble(7)+"\t\t"+rs.getInt(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
