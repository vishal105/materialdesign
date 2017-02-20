package materialtest.example.vishal.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import materialtest.example.vishal.materialdesign.R;
import materialtest.example.vishal.materialdesign.model.Login;
import materialtest.example.vishal.materialdesign.model.LoginReceive;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    // public static final String JSON_URL = "https://jsonblob.com/api/7fb0255c-f27e-11e6-901d-a72c76a6174d";

    // private ProgressDialog pDialog;
    // private String TAG = MemberActivity.class.getSimpleName();
    /*private static String url = "https://jsonblob.com/api/6235e950-f342-11e6-901d-41e65139ef8e";
    Button bt1;*/
    public EditText et_uname, et_password;
    private String username;
    private String password;
    private static String LOGIN_URL, URL1;
    Login loginModel;
    Button register;


    private String TAG = LoginActivity.class.getSimpleName();
/*
    public static final String KEY_USERNAME = "UserName";
    public static final String KEY_PASSWORD = "Password";*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        et_uname = (EditText) findViewById(R.id.et_uname);
        et_password = (EditText) findViewById(R.id.et_password);
        Button button = (Button) findViewById(R.id.bt_login);
        button.setOnClickListener(LoginActivity.this);
        register = (Button) findViewById(R.id.bt_Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_login:
                loginModel = new Login(et_uname.getText().toString(), et_password.getText().toString());
                if (loginModel.getUsername().length() >= 1) {
                    if (loginModel.getPassword().length() >= 1) {
                        userLogin();
                        // startActivity(new Intent(LoginActivity.this, LaunchActivity.class));
                    } else {
                        showToast("Please enter Password");
                    }
                } else {
                    showToast("Please enter Email/Username");
                }
                break;
            default:
                break;
        }
    }

    private void showToast(final String message) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void userLogin() {
        // loginModel = new Login(et_uname.getText().toString(), et_password.getText().toString());
        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
        String jpar = gson.toJson(loginModel);


        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jpar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Url.URL +"login/
        URL1 = "http://192.168.0.144:8080/api/web/login/";
        /*username = et_uname.getText().toString().trim();
        password = et_password.getText().toString().trim();*/
        /*LOGIN_URL = URL1+"?UserName=" + username + "&&Password=" + password;
*/
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, URL1, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        GsonBuilder builder1 = new GsonBuilder();
                        Gson gson1 = new Gson();
                        gson1 = builder1.create();
                        LoginReceive loginReceive = gson1.fromJson(response.toString(),LoginReceive.class);
                       if( loginReceive.getSuccess()== true){
                           showToast("Login Successfully");
                           startActivity(new Intent(LoginActivity.this, LaunchActivity.class));
                       }else {
                           showToast("Please Enter Valid Username/Password");
                       }




                        //startActivity(new Intent(LoginActivity.this, LaunchActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        /*jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));*/

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);

        requestQueue.add(jsonObjReq);
    }


}





