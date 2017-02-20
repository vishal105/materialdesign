package materialtest.example.vishal.materialdesign.model;

/**
 * Created by vishal on 2/13/2017.
 */

public class First {
    private String FirstName, MiddleName, LastName,  FatherName, Gender, MaritalStatus,Attchment,
             BloodGroup, Email,  CurDes, EmplyID;
    private Number DoB,Height,PhoneNumber,CTC;

    public First(String firstName, String middleName, String lastName, String fatherName, String gender, String maritalStatus, String attchment, String bloodGroup, String email, String curDes, String emplyID, Number doB, Number height, Number phoneNumber, Number CTC) {
        FirstName = "";
        MiddleName = "";
        LastName = "";
        FatherName = "";
        Gender = "";
        MaritalStatus = "";
        Attchment = "";
        BloodGroup = "";
        Email = "";
        CurDes = "";
        EmplyID = "";
        DoB = 0;
        Height = 0;
        PhoneNumber = 0;
        this.CTC = 0;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getAttchment() {
        return Attchment;
    }

    public void setAttchment(String attchment) {
        Attchment = attchment;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCurDes() {
        return CurDes;
    }

    public void setCurDes(String curDes) {
        CurDes = curDes;
    }

    public String getEmplyID() {
        return EmplyID;
    }

    public void setEmplyID(String emplyID) {
        EmplyID = emplyID;
    }

    public Number getDoB() {
        return DoB;
    }

    public void setDoB(Number doB) {
        DoB = doB;
    }

    public Number getHeight() {
        return Height;
    }

    public void setHeight(Number height) {
        Height = height;
    }

    public Number getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Number phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Number getCTC() {
        return CTC;
    }

    public void setCTC(Number CTC) {
        this.CTC = CTC;
    }
}
