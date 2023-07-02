package JDBCTest;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass {
    static Connection con;
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery1="insert into student2 values(?,?,?,?)";
    public int insertData1(DTOClass dt)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(insertQuery1);
            pStmt.setInt(1,0);
            pStmt.setString(2,dt.getS_Name());
            pStmt.setString(3,dt.getS_Address());
            pStmt.setString(4,dt.getS_Class());
            int count= pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery2="insert into subjects values(?,?)";
    public int insertData2(DTOClass dt)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(insertQuery2);
            pStmt.setInt(1,0);
            pStmt.setString(2,dt.getSub_Name());
            int count= pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery3="insert into marksscore values(?,?,?,?)";
    public int insertData3(DTOClass dt)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(insertQuery3);
            pStmt.setInt(1,dt.getM_Id());
            pStmt.setDouble(2,dt.getMarks());
            pStmt.setInt(3,dt.getS_Ref());
            pStmt.setInt(4,dt.getSub_Ref());
            int count= pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static final String displayAllQuery="SELECT * FROM student2 s INNER JOIN subjects l INNER JOIN marksscore m ON s.Roll_No = m.S_Ref AND l.Sub_Code = m.Sub_Ref";
    public ArrayList<DTOClass> displayAllRecords()
    {
        ArrayList<DTOClass> data=new ArrayList();
        PreparedStatement pStmt;
        ResultSet rs;
        try {
            pStmt=con.prepareStatement(displayAllQuery);
            rs=pStmt.executeQuery();
            DTOClass dt=null;
            while(rs.next())
            {
                dt=new DTOClass();
                int rollNo=rs.getInt(1);
                String sName=rs.getString(2);
                String sAdd=rs.getString(3);
                String sCla=rs.getString(4);
                int subCode=rs.getInt(5);
                String subName=rs.getString(6);
                int mId=rs.getInt(7);
                double marks=rs.getDouble(8);
                int sRef=rs.getInt(9);
                int subRef=rs.getInt(10);
                dt.setRoll_No(rollNo);
                dt.setS_Name(sName);
                dt.setS_Address(sAdd);
                dt.setS_Class(sCla);
                dt.setSub_Code(subCode);
                dt.setSub_Name(subName);
                dt.setM_Id(mId);
                dt.setMarks(marks);
                dt.setS_Ref(sRef);
                dt.setSub_Ref(subRef);
                data.add(dt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    //-----------------------------------------------------------------------------------------------------------------

}
