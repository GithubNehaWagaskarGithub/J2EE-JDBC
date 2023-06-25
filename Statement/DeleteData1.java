package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData1 {
    public static void main(String[] args) {//Delete a data by passing a Dynamic values using scanner class
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a id :");
        int id= sc.nextInt();

        Connection con=null;
        Statement stmt=null;

        String query="delete from employee where emp_id="+id+"";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            if(count>0)
            {
                System.out.println(count+" Record is deleted");
            }
            else {
                System.out.println("Record not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
