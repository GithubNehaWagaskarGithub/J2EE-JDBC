package PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudArrayList1 {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pStmt=null;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number of student do you want to add :");
        int num=sc.nextInt();

        ArrayList<Student> stud=new ArrayList<Student>();
        for (int i=0;i<num;i++)
        {
            System.out.println("Enter a Roll No :");
            int rollNo= sc.nextInt();
            System.out.println("Enter a Name :");
            String name=sc.next();
            System.out.println("Enter a Div :");
            //String div=sc.next();
            char div=sc.next().charAt(0);

            stud.add(new Student(rollNo,name,div));
        }
        System.out.println("Data inserted");

        System.out.println("Do you want to display the data Yes/No :");
        String ans=sc.next();
        if(ans.equalsIgnoreCase("yes"))
        {
            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9", "root", "Neha@123");
                pStmt=con.prepareStatement("insert into student values(?,?,?)");
                for (int i=0;i<stud.size();i++)
                {
                    pStmt.setInt(1,stud.get(i).getRollNo());
                    pStmt.setString(2,stud.get(i).getName());
                    pStmt.setString(3,stud.get(i).getDiv()+"");
                    pStmt.addBatch();//addBatch() method is compiles and execute only once. And it will return int[].
                                     //suppose there is 1000 statement = means for compilation it will take 1 sec and for
                                   //execution it will take only 1 sec So our application will execute in only one second.
                                    //so for to add multiple records inside table in minimum time we have to use addBatch().
                }
                int[] arr=pStmt.executeBatch();
                System.out.println("Data inserted into Table");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Thank you for Visiting");
        }
    }
}
