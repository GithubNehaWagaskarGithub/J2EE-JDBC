package OneToManyRelationship;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayData {

        public static void main(String[] args) {
            Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;

            String query="select * from product1";

            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
                stmt= con.createStatement();
                rs=stmt.executeQuery(query);

                while (rs.next())
                {
                    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\t"+rs.getInt(5));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
