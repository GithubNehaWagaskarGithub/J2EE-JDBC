package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {//Delete a data by passing a hard Code values using scanner class
        Connection con=null;
        Statement stmt=null;
        String query="delete from employee where emp_id=7";
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
            int count=stmt.executeUpdate(query);
            if(count>0)
            {
                System.out.println(count+" Record is deleted");
            }
            else {
                System.out.println("Record is not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
