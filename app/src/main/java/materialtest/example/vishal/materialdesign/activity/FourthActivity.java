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

import java.util.Calendar;

import materialtest.example.vishal.materialdesign.R;

public class FourthActivity extends AppCompatActivity {
    TextView datefI,datetI,datefA,datetA;
    Calendar myCalendar = Calendar.getInstance();
    int day = myCalendar.get(Calendar.DAY_OF_MONTH);
    int month = myCalendar.get(Calendar.MONTH);
    int year = myCalendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button save = (Button) findViewById(R.id.bt_save) ;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FourthActivity.this,LaunchActivity.class));
            }
        });
        datefI = (TextView) findViewById(R.id.datefI);

        datefI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(FourthActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                datefI.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              /*  updatelabel();  */

                            }

                      /*      private void updatelabel() {
                                String myFormat = "MM/dd/yy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                date.setText(sdf.format(myCalendar.getTime()));
                            }*/
                        }, year,month,day);
                datePickerDialog.show();
            }
        });

        datetI = (TextView) findViewById(R.id.datetI);

        datetI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(FourthActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                datetI.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              /*  updatelabel();  */

                            }

                      /*      private void updatelabel() {
                                String myFormat = "MM/dd/yy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                date.setText(sdf.format(myCalendar.getTime()));
                            }*/
                        },year,month,day);
                datePickerDialog.show();
            }
        });

        datefA = (TextView) findViewById(R.id.datefA);

        datefA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(FourthActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                datefA.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              /*  updatelabel();  */

                            }

                      /*      private void updatelabel() {
                                String myFormat = "MM/dd/yy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                date.setText(sdf.format(myCalendar.getTime()));
                            }*/
                        },year,month,day);
                datePickerDialog.show();
            }
        });

        datetA = (TextView) findViewById(R.id.datetA);

        datetA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(FourthActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                datetA.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              /*  updatelabel();  */

                            }

                      /*      private void updatelabel() {
                                String myFormat = "MM/dd/yy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                date.setText(sdf.format(myCalendar.getTime()));
                            }*/
                        },year,month,day);
                datePickerDialog.show();
            }
        });
    }


}
