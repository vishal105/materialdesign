package materialtest.example.vishal.materialdesign.model;

/**
 * Created by vishal on 2/13/2017.
 */

public class Third {
    private String OfficeName,IntialDes,ModeofRec,EmployeeType,BsicPay;
    private Number DateofJoin,DateofApp;

    public Third(Number dateofApp, String officeName, String intialDes, String modeofRec, String employeeType, String bsicPay, Number dateofJoin) {
        DateofApp = 0;
        OfficeName = "";
        IntialDes = "";
        ModeofRec = "";
        EmployeeType = "";
        BsicPay = "";
        DateofJoin = 0;
    }

    public Number getDateofApp() {
        return DateofApp;
    }

    public void setDateofApp(Number dateofApp) {
        DateofApp = dateofApp;
    }

    public String getOfficeName() {
        return OfficeName;
    }

    public void setOfficeName(String officeName) {
        OfficeName = officeName;
    }

    public String getIntialDes() {
        return IntialDes;
    }

    public void setIntialDes(String intialDes) {
        IntialDes = intialDes;
    }

    public String getModeofRec() {
        return ModeofRec;
    }

    public void setModeofRec(String modeofRec) {
        ModeofRec = modeofRec;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String employeeType) {
        EmployeeType = employeeType;
    }

    public String getBsicPay() {
        return BsicPay;
    }

    public void setBsicPay(String bsicPay) {
        BsicPay = bsicPay;
    }

    public Number getDateofJoin() {
        return DateofJoin;
    }

    public void setDateofJoin(Number dateofJoin) {
        DateofJoin = dateofJoin;
    }
}
