package Images;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//blob=binary large object
//tinyblob= 255 byte
//blob= 64kb
//mediumblob= 16mb
//largeblob=4gb
//1px=8bits red+8bits green+8bits blue=3byte
public class ImageStorage {

    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pStmt=null;
        FileInputStream fIn = null;
        try
        {
            fIn = new FileInputStream("C:\\Users\\Ankita\\OneDrive\\Pictures\\PJ\\Venus.jpg");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try
        {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","mysql123");
            pStmt=con.prepareStatement("insert into image values(?,?,?)");
            pStmt.setInt(1,0);
            pStmt.setString(2,"Venus");
            pStmt.setBlob(3,fIn);
            int count= pStmt.executeUpdate();
            if(count>0){
                System.out.println("Image Inserted Successfully");
            }else{
                System.out.println("Something Went Wrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}