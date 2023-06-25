package Student1;

import java.sql.*;

public class StudentOperation {

    static Connection con=null;
    static PreparedStatement pStmt=null;

    static{
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addData(String sName, String cName, String uName, double sci, double java, double math, String city)
    {
        String insertQuery="insert into student1 values(?,?,?,?,?,?,?,?)";
        try {
            pStmt= con.prepareStatement(insertQuery);
            pStmt.setInt(1,0);
            pStmt.setString(2,sName);
            pStmt.setString(3,cName);
            pStmt.setString(4,uName);
            pStmt.setDouble(5,sci);
            pStmt.setDouble(6,java);
            pStmt.setDouble(7,math);
            pStmt.setString(8,city);

            int count=pStmt.executeUpdate();
            if(count>0)
            {
                System.out.println("Congrats "+count+" Data Added Successfully !!!!!!!!!!!!!!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------------
    public void displayData(int id)
    {
        ResultSet rs=null;
        String displayQuery="select * from student1 where Id=?";
        try {
            pStmt=con.prepareStatement(displayQuery);
            pStmt.setInt(1,id);
            rs=pStmt.executeQuery();
            if(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6)+"\t"+rs.getDouble(7)+"\t"+rs.getString(8));
            }
            else {
                System.out.println("OOPS !!!! Data Not Present");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------
    public void displayAllData()
    {
        ResultSet rs=null;
        String displayAllQuery="select * from student1";
        try {
            pStmt=con.prepareStatement(displayAllQuery);
            rs=pStmt.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6)+"\t"+rs.getDouble(7)+"\t"+rs.getString(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------
    public void check()
    {
        ResultSet rs = null;
        //String checkQuery = "SELECT * FROM student1 WHERE C_Name IN ( SELECT C_Name FROM student1 GROUP BY C_Name) having C_Name=?";
        String checkQuery = "SELECT * FROM student1 GROUP BY C_Name";
        try {
            pStmt = con.prepareStatement(checkQuery);
            //pStmt.setString(1, cName);

            rs = pStmt.executeQuery();

            while (rs.next())
            {
                double avg = (rs.getDouble(5) +rs.getDouble(6) + rs.getDouble(7)) / 3 ;
                if(avg > 20)
                {
                    System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6)+"\t"+rs.getDouble(7)+"\t"+rs.getString(8));
                    System.out.println("Total Percentage is :" + avg);
                    System.out.println("-------------------------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
