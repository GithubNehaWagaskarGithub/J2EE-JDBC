package Student1;

import java.sql.*;

public class StudentOperation2 {
    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement pStmt=null;
        ResultSet rs=null;

        String checkQuery = "SELECT * FROM student1 WHERE C_Name IN ( SELECT C_Name FROM student1 GROUP BY C_Name) having C_Name=?";
            try {
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
                pStmt = con.prepareStatement(checkQuery);
//                pStmt.setString(1, C_Name);

                rs = pStmt.executeQuery();

                while (rs.next())
                {
                    double avg = (rs.getDouble(5) +rs.getDouble(6) + rs.getDouble(7)) / 3 ;
                    if(avg > 60)
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
