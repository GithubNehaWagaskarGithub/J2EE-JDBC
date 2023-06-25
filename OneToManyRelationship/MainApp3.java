package OneToManyRelationship;

import java.sql.*;

public class MainApp3 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        //DISPLAY LIST OF QUANTITY SOLD AGAINST EACH PRODUCT_CATEGORY
        String query1="select p_Category,count(*) from product1 group by p_Category";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query1);
            while (rs.next())
            {
                System.out.println(rs.getString(1)+"\t = "+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
