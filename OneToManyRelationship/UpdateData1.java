package OneToManyRelationship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData1 {
    static Connection con = null;
    static Statement stmt = null;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9", "root", "Neha@123");
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateId(int id, int setId) {
        String idQuery = "update customer set c_Id=" + setId + " where c_Id=" + id + "";
        try {
            int count = stmt.executeUpdate(idQuery);
            if (count > 0) {
                System.out.println(count + " Data Updated");
            } else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    public void updateName(String name, String setName) {
        String nameQuery = "update customer set c_Name='" + setName + "' where c_Name='" + name + "'";
        try {
            int count = stmt.executeUpdate(nameQuery);
            if (count > 0) {
                System.out.println(count + " Data Updated");
            } else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------------------------------------------------------------------------------------------
    public void updateAddress(String address, String setAddress) {
        String categoryQuery = "update product1 set c_Address='" + setAddress + "' where c_Address='" + address + "'";
        try {
            int count = stmt.executeUpdate(categoryQuery);
            if (count > 0) {
                System.out.println(count + " Data Updated");
            } else {
                System.out.println("Data Not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
