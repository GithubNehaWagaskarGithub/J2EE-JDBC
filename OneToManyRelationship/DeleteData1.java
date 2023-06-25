package OneToManyRelationship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Id :");
        int c_id= sc.nextInt();

        Connection con=null;
        Statement stmt=null;

        String deleteQuery="delete from customer where c_Id="+c_id+"";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(deleteQuery);
            if(count>0)
            {
                System.out.println(count+" Record deleted");
            }
            else {
                System.out.println("Record not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

