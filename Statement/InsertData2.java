package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData2 {
    public static void main(String[] args) {//insert a data by passing hard code values using another insert query

        Connection con=null;
        Statement stmt=null;

        String query="insert into employee(emp_id,emp_Name)values(5,'Radha')";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            System.out.println(count+" Data inserted Successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
