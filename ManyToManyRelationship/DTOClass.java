package ManyToManyRelationship;

public class DTOClass
{
    private int P_No;
    private String P_Name;
    private double P_Rate;
    private int W_No;
    private String W_Name;
    private String W_Address;
    private String W_City;
    private int PW_Id;
    private int P_Ref;
    private int W_Ref;

    public int getP_No() {
        return P_No;
    }

    public void setP_No(int p_No) {
        P_No = p_No;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public double getP_Rate() {
        return P_Rate;
    }

    public void setP_Rate(double p_Rate) {
        P_Rate = p_Rate;
    }

    public int getW_No() {
        return W_No;
    }

    public void setW_No(int w_No) {
        W_No = w_No;
    }

    public String getW_Name() {
        return W_Name;
    }

    public void setW_Name(String w_Name) {
        W_Name = w_Name;
    }

    public String getW_Address() {
        return W_Address;
    }

    public void setW_Address(String w_Address) {
        W_Address = w_Address;
    }

    public String getW_City() {
        return W_City;
    }

    public void setW_City(String w_City) {
        W_City = w_City;
    }

    public int getPW_Id() {
        return PW_Id;
    }

    public void setPW_Id(int PW_Id) {
        this.PW_Id = PW_Id;
    }

    public int getP_Ref() {
        return P_Ref;
    }

    public void setP_Ref(int p_Ref) {
        P_Ref = p_Ref;
    }

    public int getW_Ref() {
        return W_Ref;
    }

    public void setW_Ref(int w_Ref) {
        W_Ref = w_Ref;
    }
}
