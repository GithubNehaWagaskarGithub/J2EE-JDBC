package DTODAODesignPattern;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass {
    static Connection con;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    private static final String insertData="insert into course values(?,?,?)";
    public int insertData(DTOClass c1)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(insertData);
            pStmt.setInt(1,0);
            pStmt.setString(2, c1.getCName());
            pStmt.setDouble(3,c1.getCFees());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private static final String updateData="update course set cName=? where cId=?";
    public int updateData(DTOClass dtoClass)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(updateData);
            pStmt.setString(1,dtoClass.getCName());
            pStmt.setInt(2,dtoClass.getCId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------
    private static final String updateData1="update course set cName=? where cName=?";
    public int updateData1(DTOClass dtoClass,String oldName)
    {
        PreparedStatement pStmt;
        ResultSet rs = null;
        try {
            pStmt = con.prepareStatement(updateData1);
            pStmt.setString(1,dtoClass.getCName());
            pStmt.setString(2,oldName);
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery="delete from course where cId=?";
    public int deleteData(DTOClass dtoClass)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(deleteQuery);
            pStmt.setInt(1,dtoClass.getCId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery1="select cName from course";
    public ArrayList<String> displayData1()
    {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<String> data=new ArrayList<>();
        try {
            pStmt=con.prepareStatement(displayQuery1);
            rs= pStmt.executeQuery();
            while(rs.next())
            {
                String name=rs.getString(1);
                data.add(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String displayAllQuery="select * from course";
    public static ArrayList<DTOClass> displayAllData()
    {
        PreparedStatement pStmt;
        ResultSet rs;

        ArrayList<DTOClass> data = new ArrayList<>();

        try
        {
            pStmt = con.prepareStatement(displayAllQuery);
            rs = pStmt.executeQuery();
            DTOClass dt=null;
            while (rs.next())
            {
                dt=new DTOClass();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double fees=rs.getDouble(3);
                dt.setCId(id);
                dt.setCName(name);
                dt.setCFees(fees);
                data.add(dt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
