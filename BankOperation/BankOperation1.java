package BankOperation;

import java.sql.*;

public class BankOperation1
{
        static Connection con= null;
        static int accountNumber = 0;
        static String userName=null;
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
                    accountNumber = rs.getInt(1);
                    return true;
                } else {
                    return false;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//-------------------------------------------------------------------------------------------------------------------------------
public static void depositAmount(double depo) {
    PreparedStatement psmt = null;
    String query = "select Total_Amount from userlogin full join bankpassbook on Account_No=Acc_No where Account_No=? order by Tran_Id desc limit 1";
    try {
        psmt= con.prepareStatement(query);
        ResultSet rs = null;
        psmt.setDouble(1,accountNumber);
        rs = psmt.executeQuery();
        if(rs.next()){
            double ans =rs.getDouble(1)+depo;
            System.out.println("Account bal =" + (rs.getDouble(1)+depo));

            psmt=con.prepareStatement("insert into bankpassbook (Total_Amount,Deposite,Acc_No,Withdraw) values (?,?,?,?)");
            psmt.setDouble(1,ans);
            psmt.setDouble(2,depo);
            psmt.setDouble(3,accountNumber);
            psmt.setDouble(4,0);
            int x = psmt.executeUpdate();
            System.out.println(x + "Amount Deposited");

        }else {
            System.out.println("SOMETHING WENT WRONG");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------
    public static void withdrawAmount(double with) {
        PreparedStatement psmt = null;
        String query = "select Total_Amount from userlogin full join bankpassbook on Account_No=Acc_No where Account_No=? order by Tran_Id desc limit 1";
        try {
            psmt= con.prepareStatement(query);
            ResultSet rs = null;
            psmt.setDouble(1,accountNumber);
            rs = psmt.executeQuery();
            if(rs.next()){
                double ans =rs.getDouble(1)-with;
                System.out.println("Account bal" + (rs.getDouble(1)-with));

                psmt=con.prepareStatement("insert into bankpassbook (Total_Amount,Deposite,Acc_No,Withdraw) values (?,?,?,?)");
                psmt.setDouble(1,ans);
                psmt.setDouble(2,0);
                psmt.setDouble(3,accountNumber);
                psmt.setDouble(4,with);
                int x = psmt.executeUpdate();
                System.out.println(x + "amount Withdraw");

            }else {
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------------
    public static void accountTransactions() {
        PreparedStatement psmt=null;
        try {
            psmt = con.prepareStatement("select * from  bankpassbook where Acc_No=?");
            psmt.setDouble(1,accountNumber);
            ResultSet res = null;
            res = psmt.executeQuery();
            System.out.println("---------------------TRANSACTION DETAILS------------------------");
            while(res.next()){

                System.out.println("Total amount : " +res.getDouble(2));
                System.out.println("Deposited amount : " + res.getDouble(3));
                System.out.println("Withdrawal amount : "+ res.getDouble(4));
                System.out.println("--------------------------------------------------------");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 //------------------------------------------------------------------------------------------------------------------------------
        public static void checkBalance() {
            PreparedStatement pStmt = null;
            String query = "select Total_Amount from userlogin full join bankpassbook on Account_No=Acc_No where Account_No=? order by Tran_Id desc limit 1";
            try {
                pStmt= con.prepareStatement(query);
                ResultSet rs = null;
                pStmt.setDouble(1,accountNumber);
                rs = pStmt.executeQuery();
                if(rs.next()){
                    double ans =rs.getDouble(1);
                    System.out.println("Account Balance = " + rs.getDouble(1));
                }else {
                    System.out.println("SOMETHING WENT WRONG");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
