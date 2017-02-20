package materialtest.example.vishal.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import materialtest.example.vishal.materialdesign.R;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {
    Button done;
    EditText NewPassword,OldPassword,ConfirmPassword;
    String confirmpassword,newpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        invitViews();

        done.setOnClickListener(ChangePasswordActivity.this);

    }

    private void invitViews() {
        done = (Button) findViewById(R.id.bt_done);
        NewPassword = (EditText) findViewById(R.id.et_newpassword);
        OldPassword = (EditText) findViewById(R.id.et_oldpassword);
        ConfirmPassword = (EditText) findViewById(R.id.et_confirmpassword);

    }


    @Override
    public void onClick(View v) {
        newpassword = NewPassword.getText().toString();
        confirmpassword = ConfirmPassword.getText().toString();
        if (confirmpassword.equals(NewPassword)){
            startActivity(new Intent(ChangePasswordActivity.this,LaunchActivity.class));
        }else {
            Toast.makeText(ChangePasswordActivity.this,"Please Enter Same Password",Toast.LENGTH_SHORT).show();
        }

    }
}
