package IPL;

import java.sql.*;

public class IPLOperation {
    static Connection con=null;
    static PreparedStatement pStmt=null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public void qualifiedTeams()
    {
        String query="select * from ipl where Win>=8";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public void best()
    {
        String query="select Team,max(Win*2) from ipl";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            System.out.println("Team\tPoints");
            while(rs.next())
            {
                //int best=rs.getInt(4)*2;
                System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void worst()
    {
        String query="select Team,min(Win*2) from ipl";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            System.out.println("Team\tPoints");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void avg() {
        String query = "select Team,avg(Win*2) from ipl";
        try {
            pStmt = con.prepareStatement(query);
            ResultSet rs = null;
            rs = pStmt.executeQuery();

            while (rs.next())
            {
                System.out.println(rs.getString(1)+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------
    public void win_Loss()
    {
        String query="select * from ipl where Win=Loss";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------
    public void tied()
    {
        String query="select * from ipl where tied is not null";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------
    public void winGreaterThanLoss()
    {
        String query="select * from ipl where Win>Loss";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getDouble(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    public void teamAccordingPoints()
    {
        String query="select * from ipl order by Win desc";
        try {
            pStmt=con.prepareStatement(query);
            ResultSet rs=null;
            rs=pStmt.executeQuery();
            System.out.println("Index\tTeam\tPoint");
            while(rs.next())
            {
                int point= rs.getInt(4)*2+rs.getInt(6);
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+point);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


