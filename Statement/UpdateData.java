package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {//update a data by end user using scanner class
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Name :");
        String name=sc.next();

        String query="update employee set emp_Name='"+name+"' where emp_id="+id;

        Connection con=null;
        Statement stmt=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            int count= stmt.executeUpdate(query);
            if(count>0)
            {
                System.out.println(count+" data updated");
            }
            else {
                System.out.println("Data Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
