package Images;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class ImageDisplay {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name ");
        String filename = sc.next();
        Connection con=null;
        PreparedStatement pStmt=null;
        ResultSet rs = null;

        try {
            FileOutputStream fOut = new FileOutputStream("C:\\Users\\Ankita\\OneDrive\\Pictures"+filename+".jpg");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","mysql123");
            pStmt = con.prepareStatement("select * from image");
            rs = pStmt.executeQuery();
            Blob blob;
            byte [] b = new byte[0];
            if(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                blob = rs.getBlob(3);
                b = blob.getBytes(1,(int)blob.length());
                fOut.write(b);
                fOut.close();
            }
            System.out.println(b.length);
            System.out.println(Arrays.toString(b));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}