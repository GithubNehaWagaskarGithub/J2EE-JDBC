package Demo;

import java.sql.*;
import java.util.Scanner;

public class DisplayData1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter min sal");
        double min_sal=sc.nextDouble();
        System.out.println("Enter max sal");
        double max_sal=sc.nextDouble();

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        String query="select * from employee where emp_sal between "+min_sal+" and "+max_sal+"";
        System.out.println("ID\tNAME\tSALARY");
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            while (rs.next())
            {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double salary=rs.getDouble(3);
                System.out.println(id+"\t"+name+"\t"+salary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
