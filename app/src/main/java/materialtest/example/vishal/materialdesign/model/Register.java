package materialtest.example.vishal.materialdesign.model;

/**
 * Created by vishal on 2/18/2017.
 */

public class Register {
    private String Name,Phone,Email,Password;

    public Register(String name, String phone, String email, String password) {
        Name = name;
        Phone = phone;
        Email = email;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}