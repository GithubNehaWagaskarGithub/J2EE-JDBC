package Statement;

import java.sql.*;

public class InsertData {
    public static void main(String[] args) {//data inserted by passing hard code values
        Connection con=null;
        Statement stmt=null;
        String query="insert into employee values(5,'Sima',21000.00)";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println(count+" Data inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
