package materialtest.example.vishal.materialdesign.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Calendar;

import materialtest.example.vishal.materialdesign.R;

public class ThirdActivity extends AppCompatActivity {
    TextView dateoj, dateoa;
    Calendar myCalendar = Calendar.getInstance();
    int day = myCalendar.get(Calendar.DAY_OF_MONTH);
    int month = myCalendar.get(Calendar.MONTH);
    int year = myCalendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dateoj = (TextView) findViewById(R.id.dateoj);

        dateoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ThirdActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateoj.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        Button next = (Button) findViewById(R.id.bt_next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, FourthActivity.class));
            }
        });

    dateoa=(TextView)findViewById(R.id.dateoa);

    dateoa.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        DatePickerDialog datePickerDialog = new DatePickerDialog(ThirdActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateoj.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

            }
        }, year, month, day);
        datePickerDialog.show();
    }
    });
}

}
