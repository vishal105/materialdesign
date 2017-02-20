package materialtest.example.vishal.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import materialtest.example.vishal.materialdesign.R;

public class SecondActivity extends AppCompatActivity {
    EditText et_preadd,et_state,et_dis,et_block1,et_pan,et_pcode,et_pno1,et_mno,et_email,et_peradd,et_pstate,et_pdis,et_block,et_ppan,et_ppcod,et_pno2;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        invitViews();

        next.setOnClickListener(new View.OnClickListener() {
            String add = et_preadd.getText().toString().trim();
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
                    //Toast.makeText(SecondActivity.this,"please enter all field",Toast.LENGTH_SHORT).show();
        });

    }


    private void invitViews() {
        next= (Button) findViewById(R.id.bt_next1);
        et_preadd = (EditText) findViewById(R.id.et_preadd);
        et_state = (EditText) findViewById(R.id.et_state);
        et_dis = (EditText) findViewById(R.id.et_dis);
        et_block1 = (EditText) findViewById(R.id.et_block1);
        et_pan = (EditText) findViewById(R.id.et_pan);
        et_pcode = (EditText) findViewById(R.id.et_pcode);
        et_pno1 = (EditText) findViewById(R.id.et_pno1);
        et_mno = (EditText) findViewById(R.id.et_mno);
        et_email = (EditText) findViewById(R.id.et_email);
        et_peradd = (EditText) findViewById(R.id.et_peradd);
        et_pstate = (EditText) findViewById(R.id.et_pstate);
        et_pdis = (EditText) findViewById(R.id.et_pdis);
        et_block = (EditText) findViewById(R.id.et_block);
        et_ppan = (EditText) findViewById(R.id.et_ppan);
        et_ppcod = (EditText) findViewById(R.id.et_ppcod);
        et_pno2 = (EditText) findViewById(R.id.et_pno2);
    }
}


