package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Connection con=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i=0;i<4;i++)
        {
            System.out.println("Enter a id :");
            int id=sc.nextInt();
            System.out.println("Enter a name :");
            String name=sc.next();
            System.out.println("Enter a salary :");
            double sal=sc.nextDouble();

            String query="insert into employee values("+id+",'"+name+"',"+sal+")";
            Statement stmt=null;
            try {
                stmt=con.createStatement();
                int count= stmt.executeUpdate(query);
                System.out.println(count+" Data inserted Successfully");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
