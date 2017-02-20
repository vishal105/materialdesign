package materialtest.example.vishal.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
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
import materialtest.example.vishal.materialdesign.model.LoginReceive;
import materialtest.example.vishal.materialdesign.model.Register;

public class RegisterActivity extends AppCompatActivity {
    Button save;
    public static final String REGISTER_URL = "http://192.168.0.144:8080/api/web/register";
    EditText registername, registerphone, registeremail, registerpassword;
    Register registermodel;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        registername = (EditText) findViewById(R.id.et_registername);
        registerphone = (EditText) findViewById(R.id.et_registrphoneno);
        registeremail = (EditText) findViewById(R.id.et_registeremail);
        registerpassword = (EditText) findViewById(R.id.et_registerpassword);


        save = (Button) findViewById(R.id.bt_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registermodel = new Register(registername.getText().toString()
                        , registerphone.getText().toString(), registeremail.getText().toString(), registerpassword.getText().toString());
                registerUser();

               /* if (registermodel.getName().length() >= 1) {
                    if (registermodel.getPhone().length() >= 1) {
                        if (registermodel.getEmail().length() >= 1) {
                            if (registermodel.getPassword().length() >= 1) {

                            }else{
                                Toast.makeText(RegisterActivity.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this,"Please Enter Email ID",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"Please Enter Phone NO.",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(RegisterActivity.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                }*/


            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }


    private void registerUser() {
        /*final String RegName = registername.getText().toString().trim();
        final String RegPhno = registerphone.getText().toString().trim();
        final String RegMail = registeremail.getText().toString().trim();
        final String RegPas = registerpassword.getText().toString().trim();*/
        Gson gson = new Gson();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.create();
        String jpar1 = gson.toJson(registermodel);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jpar1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson1 = new Gson();
                        GsonBuilder gsonBuilder1 = new GsonBuilder();
                        gsonBuilder1.create();
                        LoginReceive loginReceive = gson1.fromJson(response.toString(), LoginReceive.class);
                        if (loginReceive.getSuccess()== true) {
                            Toast.makeText(RegisterActivity.this,"Register Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                        } else {
                            Toast.makeText(RegisterActivity.this, "Please Try again", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        objectRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(objectRequest);


    }
}
