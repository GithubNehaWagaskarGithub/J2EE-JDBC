package BankOperation;

import java.sql.*;

public class BankOperation
{
    static Connection con= null;
    static int accountNumber = 0;
    static String userName=null;
    static double accountBal=0.0;
    //-----------------------------------------------------------------------------------------------------------------------------
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    public static boolean LoginValidation(String username, String password) {
        PreparedStatement pStmt = null;
        String query = "select * from userlogin where User_Name=? and User_Pass=?";
        ResultSet rs = null;
        try {
            pStmt = con.prepareStatement(query);
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                userName = rs.getNString(2);
                String passward=rs.getString(3);
                accountNumber = rs.getInt(1);
                if((username).equals(username)&&(passward).equals(password))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void DepositAmount(double amt) {
        accountBal=checkBalance();
        String query="insert into bankpassbook values(?,?,?,?,?)";
        PreparedStatement pStmt=null;
        try {
            pStmt= con.prepareStatement(query);
            pStmt.setInt(1,0);
            pStmt.setDouble(2,(accountBal+amt));
            pStmt.setDouble(3,amt);
            pStmt.setDouble(4,0);
            pStmt.setInt(5,accountNumber);
            int count=pStmt.executeUpdate();
            if(count>0)
            {
                System.out.println(amt+"Deposited Successfully");
            }
            else {
                System.out.println("Something Went Wrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------
    public static void withdrawAmount(double amt)
    {
        if(checkBalance()>=amt)
        {
            String query = "insert into bankpassbook values(?,?,?,?,?)";
            PreparedStatement pStmt = null;
            try {
                pStmt = con.prepareStatement(query);
                pStmt.setInt(1, 0);
                pStmt.setDouble(2, (accountBal - amt));
                pStmt.setDouble(3, 0);
                pStmt.setDouble(4, amt);
                pStmt.setInt(5, accountNumber);
                int count = pStmt.executeUpdate();
                if (count > 0) {
                    System.out.println(amt + "Withdraw Successfully");
                } else {
                    System.out.println("Something Went Wrong");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println();
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    public static double checkBalance() {
        PreparedStatement pStmt = null;
        String query = "select Total_Amount from userlogin full join bankpassbook on Account_No=Acc_No where Account_No=? order by Tran_Id desc limit 1;";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs = null;
            pStmt.setDouble(1,accountNumber);
            rs = pStmt.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }else {
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public static void accountStatement()
    {
        PreparedStatement pStmt = null;
        String query = "select * from bankpassbook where Acc_No=?";
        try {
            pStmt= con.prepareStatement(query);
            ResultSet rs = null;
            pStmt.setInt(1,accountNumber);
            rs = pStmt.executeQuery();
            System.out.println("Account Statement = "+userName);
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+ rs.getDouble(2)+"\t"+ rs.getDouble(3)+"\t"+ rs.getDouble(4)+"\t"+ rs.getInt(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}