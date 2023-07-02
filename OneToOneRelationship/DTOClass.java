package OneToOneRelationship;

public class DTOClass {
    private int P_Id;
    private String P_Name;
    private String P_Address;
    private int C_Id;

    private String City;
    private int Ph_No;
    private int P_Ref;

    public int getP_Id() {
        return P_Id;
    }

    public void setP_Id(int p_Id) {
        P_Id = p_Id;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public String getP_Address() {
        return P_Address;
    }

    public void setP_Address(String p_Address) {
        P_Address = p_Address;
    }
    public int getC_Id() {
        return C_Id;
    }

    public void setC_Id(int c_Id) {
        C_Id = c_Id;
    }
    public int getP_Ref() {
        return P_Ref;
    }

    public void setP_Ref(int p_Ref) {
        P_Ref = p_Ref;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getPh_No() {
        return Ph_No;
    }

    public void setPh_No(int ph_No) {
        Ph_No = ph_No;
    }
}
