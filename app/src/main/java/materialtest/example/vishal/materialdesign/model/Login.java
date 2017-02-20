package materialtest.example.vishal.materialdesign.model;

/**
 * Created by vishal on 2/13/2017.
 */

public class Login {
    private String Username, Password;

    public Login(String username, String password) {
        Username = username;
        Password = password;
    }

    public String getPassword() {return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}

