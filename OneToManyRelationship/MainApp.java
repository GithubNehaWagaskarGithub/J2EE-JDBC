package OneToManyRelationship;

import java.sql.*;

public class MainApp {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        //DISPLAY ALL CUSTOMER DETAILS IN ASCENDING ORDER
        String query="select * from customer order by c_Name asc";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query);
            System.out.println("C_Id\tC_Name\tC_Address");
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
