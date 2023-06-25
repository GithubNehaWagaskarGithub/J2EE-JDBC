package Weapon;

import java.sql.*;

public class WeaponOperation {
    static Connection con=null;
    static PreparedStatement pStmt=null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------
    public void damageIsWorst()
    {
        String query="SELECT WeaponName,MIN(Damage) FROM weapon GROUP BY WeaponName ORDER BY Damage LIMIT 1";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs=null;
            rs= pStmt.executeQuery();
            System.out.println("damage is Worst :");
            while (rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    public void weaponRangeBetween400And600()
    {
        String query="SELECT WeaponName,Ranges FROM weapon WHERE Ranges BETWEEN 400 AND 600";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs=null;
            rs= pStmt.executeQuery();
            System.out.println("Weapon Range Between 400 And 600 :");
            while (rs.next())
            {
                System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    public void WeaponTypesAndThereCount()
    {
        String query="SELECT WeaponType,COUNT(WeaponType) FROM weapon GROUP BY WeaponType :";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs=null;
            rs= pStmt.executeQuery();
            System.out.println("Weapon Types and Their Counts");
            while (rs.next())
            {
                System.out.println(rs.getString(1)+" = "+rs.getInt(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------
    public void TotalDamageDoneByAssaultRiffle()
    {
        String query="SELECT SUM(Damage) FROM weapon WHERE WeaponType='AssaultRiffle'";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs=null;
            rs= pStmt.executeQuery();
            System.out.println("Total Damage done by Assault Riffle :");
            while (rs.next())
            {
                System.out.println("Total Damage by AssaultRiffle is = "+rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    public void WeaponNamesWhichDoesNotContainCCharacter()
    {
        String query="SELECT WeaponName FROM weapon WHERE WeaponName NOT LIKE '%C%'";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs=null;
            rs= pStmt.executeQuery();
            System.out.println("Weapon Names which does not contain 'C' Character :");
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    public void WeaponNamesAndWeaponTypeAfterRemovingFFFromTheirName()
    {
        String query="SELECT WeaponName,CONCAT(SUBSTR(WeaponType,1,9),SUBSTR(WeaponType,12)) AS WeaponTypes FROM weapon;";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs=null;
            rs= pStmt.executeQuery();
            System.out.println("Weapon Names and Weapon Type after removing 'ff' from their name :");
            while (rs.next())
            {
                System.out.println(rs.getString(1)+" = \t"+rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
