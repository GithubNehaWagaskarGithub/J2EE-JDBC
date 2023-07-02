package DTODAODesignPattern;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass2 {
    static Connection con;
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery="insert into glossary values(?,?,?,?,?)";
    public int insertData(DTOClass2 dt)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(insertQuery);
            pStmt.setInt(1,dt.getId());
            pStmt.setString(2,dt.getName());
            pStmt.setString(3,dt.getCategory());
            pStmt.setDouble(4,dt.getPrice());
            pStmt.setInt(5,dt.getQty());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery="update glossary set Name=? where Id=?";
    public int updateData(DTOClass2 dt)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(updateQuery);
            pStmt.setString(1,dt.getName());
            pStmt.setInt(2,dt.getId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery1="update glossary set Name=? where Name=?";
    public int updateData1(DTOClass2 dt, String oldName)
    {
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(updateQuery1);
            pStmt.setString(1, dt.getName());
            pStmt.setString(2,oldName);
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery="delete from glossary where Id=?";
    public int deleteData(DTOClass2 dt)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(deleteQuery);
            pStmt.setInt(1,dt.getId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery="select Category from glossary";
    public ArrayList<String> displayData()
    {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<String> data=new ArrayList<>();
        try {
            pStmt=con.prepareStatement(displayQuery);
            rs=pStmt.executeQuery();
            while(rs.next())
            {
                String category=rs.getString(1);
                data.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    //--------------------------------------------------------------------------------------------------------------------------
    private static final String displayAllDataQuery="select * from glossary";
    public ArrayList<DTOClass2> displayAllData1()
    {
        PreparedStatement pStmt;
        ResultSet rs;

        ArrayList<DTOClass2> data=new ArrayList<>();

        try {
            pStmt=con.prepareStatement(displayAllDataQuery);
            rs=pStmt.executeQuery();
            DTOClass2 dt=null;
            while(rs.next())
            {
                 dt=new DTOClass2();
                 int id=rs.getInt(1);
                 String name=rs.getString(2);
                 String category=rs.getString(3);
                 double price=rs.getDouble(4);
                 int qty=rs.getInt(5);
                 dt.setId(id);
                 dt.setName(name);
                 dt.setCategory(category);
                 dt.setPrice(price);
                 dt.setQty(qty);
                 data.add(dt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
