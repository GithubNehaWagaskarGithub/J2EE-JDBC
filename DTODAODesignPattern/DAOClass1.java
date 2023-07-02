package DTODAODesignPattern;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass1 {
    static Connection con;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery="insert into student values(?,?,?)";
    public int insertData(DTOClass1 dto)
    {
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(insertQuery);
            pStmt.setInt(1,dto.getStud_Roll_No());
            pStmt.setString(2,dto.getStud_Name());
            pStmt.setString(3,dto.getStud_Div()+"");
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery="update student set Stud_Name=? where Stud_Roll_No=?";
    public int updateData(DTOClass1 dto)
    {
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(updateQuery);
            pStmt.setString(1,dto.getStud_Name());
            pStmt.setInt(2,dto.getStud_Roll_No());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery="delete from student where Stud_Roll_No=?";
    public int deleteData(DTOClass1 dto)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(deleteQuery);
            pStmt.setInt(1,dto.getStud_Roll_No());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery="Select * from student";
    public ArrayList<DTOClass1> displayData()
    {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<DTOClass1> data=new ArrayList<>();
        try {
            pStmt= con.prepareStatement(displayQuery);
            rs=pStmt.executeQuery();
            DTOClass1 d1=null;
            while(rs.next())
            {
                d1=new DTOClass1();
                int rollNo=rs.getInt(1);
                String name=rs.getString(2);
                char div=rs.getString(3).charAt(0);
                d1.setStud_Roll_No(rollNo);
                d1.setStud_Name(name);
                d1.setStud_Div(div);
                data.add(d1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    //---------------------------------------------------------------------------------------------------------------------------
}
