package PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pStmt=null;

        String query="insert into student values(1,'Neha','A')";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9", "root", "Neha@123");
            pStmt=con.prepareStatement(query);
            int count=pStmt.executeUpdate();
            System.out.println(count+" Data Inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
