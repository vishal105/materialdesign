package materialtest.example.vishal.materialdesign.model;

import materialtest.example.vishal.materialdesign.activity.LoginActivity;

public class LoginReceive extends LoginActivity {

     private Boolean IsSuccess;

    public LoginReceive(String errors, Boolean isSuccess) {

        IsSuccess = isSuccess;
    }

    public Boolean getSuccess() {
        return IsSuccess;
    }

    public void setSuccess(Boolean success) {
        IsSuccess = success;
    }
}
