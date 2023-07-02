package BankOperation;

import java.sql.*;

public class BankOperation
{
    static Connection con= null;
    static int accountNumber = 0;
    static String userName= null;
    static double accountBal= 0.0;
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
        String query="insert into bankpassbook values(?,?,?,?,?,?)";
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
                System.out.println(amt+" Deposited Successfully");
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
        accountBal=checkBalance();
        if(checkBalance()>=amt)
        {
            String query = "insert into bankpassbook values(?,?,?,?,?,?)";
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
                    System.out.println(amt + " Withdraw Successfully");
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
    public static double checkBalance()
    {
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
                System.out.println(rs.getInt(1)+"\t"+ rs.getDouble(2)+"\t"+ rs.getDouble(3)+"\t"+ rs.getDouble(4)+"\t"+ rs.getInt(5)+"\t"+ rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void transferMoney(int accNo, double amt2)
    {
        PreparedStatement psmt = null;
        String query = "SELECT Total_Amount FROM bankpassbook FULL JOIN userlogin ON Acc_No=Account_No WHERE Account_No=? ORDER BY Tran_Id DESC LIMIT 1;";
        try {
            psmt= con.prepareStatement(query);
            ResultSet res = null;
            psmt.setDouble(1,accountNumber);
            res = psmt.executeQuery();
            if(res.next()){
                //TOTAL BAL OF LOGGED ACCOUNT
                double loggedAccTAmount = res.getDouble(1);

                //RETRIEVE THE ACCOUNT WHICH WE WANT TO TRANSFER THE MONEY
                int transferAccNo = accNo;
                double transferAmt = amt2;
                String transferQuery = "select * from bankpassbook where Acc_No=?";
                psmt = con.prepareStatement(transferQuery);
                psmt.setInt(1,accNo);
                ResultSet transferRes = psmt.executeQuery();
                if(transferRes.next()){
                    double totalAmountOfTA = transferRes.getDouble("Total_Amount");
                    if(loggedAccTAmount >= amt2){
                        //reduce the transfer amt from logged-in user.
                        double updateLoggedInBal = loggedAccTAmount - amt2;

                        //add transfer amt to transfer acc
                        double updateTransferBal = totalAmountOfTA + amt2;

                        //inserting the details
                        String insertQuery1="insert into  bankpassbook (Tran_Id,Total_Amount,Deposite,Withdraw,Acc_No,Ref_Acc_No) values(?,?,?,?,?,?)";
                        psmt= con.prepareStatement(insertQuery1);
                        psmt.setInt(1,0);
                        psmt.setDouble(2,updateLoggedInBal);
                        psmt.setDouble(3,0);
                        psmt.setDouble(4,amt2);
                        psmt.setInt(5,accountNumber);
                        psmt.setDouble(6,accNo);
                        int count = psmt.executeUpdate();
                        if(count>0)
                        {
                            System.out.println(count+" Money Withdraw Successfully");
                        }


                        String insertQuery2="insert into  bankpassbook (Tran_Id,Total_Amount,Deposite,Withdraw,Acc_No,Ref_Acc_No) values(?,?,?,?,?,?)";
                        psmt= con.prepareStatement(insertQuery2);
                        psmt.setInt(1,0);
                        psmt.setDouble(2,updateTransferBal+amt2);
                        psmt.setDouble(3,amt2);
                        psmt.setInt(4,0);
                        psmt.setInt(5,accNo);
                        psmt.setDouble(6,accountNumber);

                        int count1 = psmt.executeUpdate();
                        if(count1>0)
                        {
                            System.out.println(count1+" Money Deposit/Transfer Successfully");
                        }

                    }else{
                        System.out.println("Insufficient balance");
                    }
                }

            }else {
                System.out.println("SOMETHING WENT WRONG");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}