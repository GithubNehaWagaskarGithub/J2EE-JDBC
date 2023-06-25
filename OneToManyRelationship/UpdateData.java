package OneToManyRelationship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    static Connection con=null;
    static Statement stmt=null;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9", "root", "Neha@123");
            stmt= con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateId(int id,int setId)
    {
        String idQuery="update product1 set p_Id="+setId+" where p_Id="+id+"";
        try {
            int count=stmt.executeUpdate(idQuery);
            if(count>0)
            {
                System.out.println(count+" Data Updated");
            }
            else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    public void updateName(String name, String setName)
    {
        String nameQuery="update product1 set p_Name='"+setName+"' where p_Name='"+name+"'";
        try {
            int count=stmt.executeUpdate(nameQuery);
            if(count>0)
            {
                System.out.println(count+" Data Updated");
            }
            else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
    public void updateCategory(String category, String setCategory)
    {
        String categoryQuery="update product1 set p_Category='"+setCategory+"' where p_Category='"+category+"'";
        try {
            int count=stmt.executeUpdate(categoryQuery);
            if(count>0)
            {
                System.out.println(count+" Data Updated");
            }
            else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    public void updatePrice(double price, double setPrice)
    {
        String priceQuery="update product1 set p_Price="+setPrice+" where p_Price="+price+"";
        try {
            int count=stmt.executeUpdate(priceQuery);
            if(count>0)
            {
                System.out.println(count+" Data Updated");
            }
            else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    public void updateC_Ref(int ref, int setC_ref)
    {
        String c_RefQuery="update product1 set c_Ref="+setC_ref+" where c_Ref="+ref+"";
        try {
            int count=stmt.executeUpdate(c_RefQuery);
            if(count>0)
            {
                System.out.println(count+" Data Updated");
            }
            else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}