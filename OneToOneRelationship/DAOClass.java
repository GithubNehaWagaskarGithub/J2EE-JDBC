package OneToOneRelationship;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass {
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9", "root", "Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery1 = "insert into person values(?,?,?)";

    public int insertData1(DTOClass dt) {
        PreparedStatement pStmt;
        try {
            pStmt = con.prepareStatement(insertQuery1);
            pStmt.setInt(1, dt.getP_Id());
            pStmt.setString(2, dt.getP_Name());
            pStmt.setString(3, dt.getP_Address());
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery2 = "insert into contact values(?,?,?,?)";

    public int insertData2(DTOClass dt) {
        PreparedStatement pStmt;
        try {
            pStmt = con.prepareStatement(insertQuery2);
            pStmt.setInt(1, dt.getC_Id());
            pStmt.setString(2, dt.getCity());
            pStmt.setInt(3, dt.getPh_No());
            pStmt.setInt(4, dt.getP_Ref());
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery1 = "update person set P_Name=? where P_Id=?";

    public int updateData1(DTOClass dt) {
        PreparedStatement pStmt;
        try {
            pStmt = con.prepareStatement(updateQuery1);
            pStmt.setString(1, dt.getP_Name());
            pStmt.setInt(2, dt.getP_Id());
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery2 = "update contact set Ph_No=? where C_Id=?";

    public int updateData2(DTOClass dt) {
        PreparedStatement pStmt;
        try {
            pStmt = con.prepareStatement(updateQuery2);
            pStmt.setInt(1, dt.getPh_No());
            pStmt.setInt(2, dt.getC_Id());
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery1 = "delete from person where P_Id=?";

    public int deleteData1(DTOClass dt) {
        PreparedStatement pStmt;
        try {
            pStmt = con.prepareStatement(deleteQuery1);
            pStmt.setInt(1, dt.getP_Id());
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery2 = "delete from contact where C_Id=?";

    public int deleteData2(DTOClass dt) {
        PreparedStatement pStmt;
        try {
            pStmt = con.prepareStatement(deleteQuery2);
            pStmt.setInt(1, dt.getC_Id());
            int count = pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery1 = "SELECT * FROM person p INNER JOIN contact c ON p.P_Id =c.P_Ref WHERE P_Id=?;";

    public ArrayList<DTOClass> displayDataOfParticularRecord(int id) {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<DTOClass> data = new ArrayList<>();
        try {
            pStmt = con.prepareStatement(displayQuery1);
            pStmt.setInt(1, id);
            pStmt.executeQuery();
            rs = pStmt.executeQuery();
            DTOClass dt = null;
            while (rs.next()) {
                dt = new DTOClass();
                int pId = rs.getInt(1);
                String pName = rs.getString(2);
                String pAdd = rs.getString(3);
                int cId = rs.getInt(4);
                String cCity = rs.getString(5);
                int phNo = rs.getInt(6);
                int pRef = rs.getInt(7);
                dt.setP_Id(pId);
                dt.setP_Name(pName);
                dt.setP_Address(pAdd);
                dt.setC_Id(cId);
                dt.setCity(cCity);
                dt.setPh_No(phNo);
                dt.setP_Ref(pRef);
                data.add(dt);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery2 = "SELECT P_Id,P_Name,C_Id,Ph_No FROM person p INNER JOIN contact c ON p.P_Id =c.P_Ref;";

    public ArrayList<DTOClass> displayDataOfParticularColumn() {
        ArrayList<DTOClass> data = new ArrayList<>();
        PreparedStatement pStmt;
        ResultSet rs;
        try {
            pStmt = con.prepareStatement(displayQuery2);
            rs = pStmt.executeQuery();
            DTOClass dt = null;
            while (rs.next()) {
                dt = new DTOClass();
                int pId = rs.getInt(1);
                String pName = rs.getString(2);
                int cId = rs.getInt(3);
                int phNo = rs.getInt(4);
                dt.setP_Id(pId);
                dt.setP_Name(pName);
                dt.setC_Id(cId);
                dt.setPh_No(phNo);
                data.add(dt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    //---------------------------------------------------------------------------------------------------------------------
    private static final String displayQuery3 = "SELECT * FROM person p INNER JOIN contact c ON p.P_Id =c.P_Ref;";

    public ArrayList<DTOClass> displayAllRecords()
    {
        ArrayList<DTOClass> data=new ArrayList<>();
        PreparedStatement pStmt;
        ResultSet rs;
        try {
            pStmt= con.prepareStatement(displayQuery3);
            rs=pStmt.executeQuery();
            DTOClass dt=null;
            while(rs.next())
            {
                dt=new DTOClass();
                int pId = rs.getInt(1);
                String pName = rs.getString(2);
                String pAdd = rs.getString(3);
                int cId = rs.getInt(4);
                String cCity = rs.getString(5);
                int phNo = rs.getInt(6);
                int pRef = rs.getInt(7);
                dt.setP_Id(pId);
                dt.setP_Name(pName);
                dt.setP_Address(pAdd);
                dt.setC_Id(cId);
                dt.setCity(cCity);
                dt.setPh_No(phNo);
                dt.setP_Ref(pRef);
                data.add(dt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
