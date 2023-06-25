package Product_Simulatory;

import java.sql.*;

public class Product_Operations {
    static Connection con=null;
    static Statement stmt=null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
            stmt= con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addData(int id, String name, String category, String sub_category, Double price, int qty)
    {
        String insertQuery="insert into product values("+id+",'"+name+"','"+category+"','"+sub_category+"',"+price+","+qty+")";
        try {
            int count= stmt.executeUpdate(insertQuery);
            if(count>0)
            {
                System.out.println(count+" Data Added Successfully");
            }
            else {
                System.out.println("Data Not Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------
    public void update_Id(int id,int setId) {
        String update_Id = "update Product set Id = "+setId+"  where Id = "+id+"  ";
        try {
            int count = con.createStatement().executeUpdate(update_Id);
            if(count >0){
                System.out.println(count+" Data updated");
            }else{
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_Name(int id, String setName) {
        String update_Name = "update Product set Name = '"+setName+"'  where Name = "+id+"  ";
        try {
            int count = con.createStatement().executeUpdate(update_Name);
            if(count >0){
                System.out.println(count + " Data updated");
            }else{
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_Category(int id, String setCategory) {
        String update_category = "update Product set Category = '"+setCategory+"'  where Category = "+id+"  ";
        try {
            int count = con.createStatement().executeUpdate(update_category);
            if(count >0){
                System.out.println(count + " Data updated");
            }else{
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_SubCategory(int id, String setSubCategory) {
        String update_category = "update Product set Sub_category = '"+setSubCategory+"'  where Sub_category = "+id+"  ";
        try {
            int count = con.createStatement().executeUpdate(update_category);
            if(count >0){
                System.out.println(count + " Data updated");
            }else{
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_Price(int id, Double setPrice) {
        String update_category = "update product set Price = "+setPrice+"  where Price = "+id+"  ";
        try {
            int count = con.createStatement().executeUpdate(update_category);
            if(count >0){
                System.out.println(count + " Data updated");
            }else{
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_qty(int id, int setQty) {
        String update_category = "update product set Qty = "+setQty+"  where Qty = "+id+"  ";
        try {
            int count = con.createStatement().executeUpdate(update_category);
            if(count >0){
                System.out.println(count + " Data updated");
            }else{
                System.out.println("Data not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------
    public void deleteData(int id) {
        String deleteQuery="delete from product where Id="+id+"";
        try {
            int count= stmt.executeUpdate(deleteQuery);
            if(count>0)
            {
                System.out.println(count+" Data Deleted Successfully");
            }
            else {
                System.out.println("Data Not Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //----------------------------------------------------------------------------------------------------
    public void displayAllData()
    {
        ResultSet rs=null;
        String displayQuery="select * from product";//String displayQuery="select Product_Name,Price from product";
        try {
            rs=stmt.executeQuery(displayQuery);
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getDouble(5)+"\t"+rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
