package OneToManyRelationship;

import java.sql.*;

public class MainApp2 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        //DISPLAY ALL CUSTOMER WHO DOES NOT BUY ANY PRODUCT
        //String query1="select * from customer where c_Id not in(select c_Ref from product1 where c_Ref not in(5,8,9))";
        String query1="select * from customer where c_Id not in(select c_Ref from product1)";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query1);
            System.out.println("C_Id\t C_Name\t C_Address");
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
