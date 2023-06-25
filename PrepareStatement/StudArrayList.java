package PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudArrayList {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pStmt=null;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number of student do you want to add :");
        int num=sc.nextInt();
//      var stud=new ArrayList<>();

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
        int count=0;
        int sum=0;
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

                    count=pStmt.executeUpdate();//PrepareStatement compile only once and execute multiple times
                                                //suppose there is 1000 statement = means for compilation it will take 1 sec and for
                                                //execution it will take 1000 sec So it will take a lot of time for execute any application.
                                                //to avoid this drawback we have to use addBatch() Method.
                    sum=sum+count;
                }
                System.out.println(sum+" Data inserted into student table");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Thank you for Visiting");
        }
    }
}
