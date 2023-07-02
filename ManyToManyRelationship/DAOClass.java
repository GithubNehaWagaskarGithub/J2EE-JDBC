package ManyToManyRelationship;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass
{
    static Connection con;
    static PreparedStatement pStmt;
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery1="insert into product2 values(?,?,?)";
    public int insertData1(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(insertQuery1);
            pStmt.setInt(1,dt.getP_No());
            pStmt.setString(2,dt.getP_Name());
            pStmt.setDouble(3,dt.getP_Rate());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery2="insert into wholesaler values(?,?,?,?)";
    public int insertData2(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(insertQuery2);
            pStmt.setInt(1,dt.getW_No());
            pStmt.setString(2, dt.getW_Name());
            pStmt.setString(3,dt.getW_Address());
            pStmt.setString(4,dt.getW_City());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery3="insert into product2wholesaler values(?,?,?)";
    public int insertData3(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(insertQuery3);
            pStmt.setInt(1,dt.getPW_Id());
            pStmt.setInt(2,dt.getP_Ref());
            pStmt.setInt(3,dt.getW_Ref());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery1="update product2 set P_Name=? where P_No=?";
    public int updateData1(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(updateQuery1);
            pStmt.setString(1,dt.getP_Name());
            pStmt.setInt(2,dt.getP_No());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery2="update wholesaler set W_Name=? where W_No=?";
    public int updateData2(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(updateQuery2);
            pStmt.setString(1,dt.getW_Name());
            pStmt.setInt(2,dt.getW_No());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery3="update product2wholesaler set W_Ref=? where PW_Id=?";
    public int updateData3(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(updateQuery3);
            pStmt.setInt(1,dt.getW_Ref());
            pStmt.setInt(2,dt.getPW_Id());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery1="delete from product2 where P_No=?";
    public int deleteData1(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(deleteQuery1);
            pStmt.setInt(1,dt.getP_No());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery2="delete from wholesaler where W_No=?";
    public int deleteData2(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(deleteQuery2);
            pStmt.setInt(1,dt.getW_No());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery3="delete from product2wholesaler where PW_Id=?";
    public int deleteData3(DTOClass dt)
    {
        try {
            pStmt=con.prepareStatement(deleteQuery3);
            pStmt.setInt(1,dt.getPW_Id());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery="SELECT * FROM product2 p INNER JOIN  wholesaler w INNER JOIN product2wholesaler k ON p.P_No = k.P_Ref AND w.W_No = k.W_Ref";
    public ArrayList<DTOClass> displayAllRecords()
    {
        ResultSet rs;
        ArrayList<DTOClass> data=new ArrayList<>();
        try {
            pStmt= con.prepareStatement(displayQuery);
            rs=pStmt.executeQuery();
            DTOClass dt=null;
            while (rs.next())
            {
                dt=new DTOClass();
                int pNo=rs.getInt(1);
                String pName=rs.getString(2);
                double pRate=rs.getDouble(3);
                int wNo=rs.getInt(4);
                String wName=rs.getString(5);
                String wAdd=rs.getString(6);
                String wCity=rs.getString(7);
                int pwId=rs.getInt(8);
                int pRef=rs.getInt(9);
                int wRef=rs.getInt(10);
                dt.setP_No(pNo);
                dt.setP_Name(pName);
                dt.setP_Rate(pRate);
                dt.setW_No(wNo);
                dt.setW_Name(wName);
                dt.setW_Address(wAdd);
                dt.setW_City(wCity);
                dt.setPW_Id(pwId);
                dt.setP_Ref(pRef);
                dt.setW_Ref(wRef);
                data.add(dt);
            }
            pStmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
