package materialtest.example.vishal.materialdesign.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import materialtest.example.vishal.materialdesign.R;

public class FirstActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA = 200;
    private static final int RESULT_LOAD_IMAGE = 100;
    Calendar myCalendar = Calendar.getInstance();
    final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};
    ImageView iv1;
    EditText etf, etm, etl, eth, ets, ethi, etb, ete, etp, etcd, etei, etcs;
    private TextView date;
    Button next1, pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        invitViews();

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int day = myCalendar.get(Calendar.DAY_OF_MONTH);
                int month = myCalendar.get(Calendar.MONTH);
                int year = myCalendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(FirstActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, final int year,
                                                  final int monthOfYear, final int dayOfMonth) {

                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              /*  updatelabel();  */

                            }

                      /*      private void updatelabel() {
                                String myFormat = "MM/dd/yy"; //In which you need put here
                                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                                date.setText(sdf.format(myCalendar.getTime()));
                            }*/
                        }, year, month, day);
                datePickerDialog.show();
            }
        });


        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(FirstActivity.this);
                builder.setTitle("Add Photo!");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public int PROFILE_PIC_COUNT = REQUEST_CAMERA;

                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if (items[item].equals("Take Photo")) {
                            PROFILE_PIC_COUNT = 1;
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, REQUEST_CAMERA);
                        } else if (items[item].equals("Choose from Library")) {
                            PROFILE_PIC_COUNT = 2;

                            //getGellery();
                            Intent i = new Intent(
                                    Intent.ACTION_PICK,
                                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(i, RESULT_LOAD_IMAGE);
                            /*Intent intent = new Intent(
                                    Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(intent, SELECT_FILE);*/
                        } else if (items[item].equals("Cancel")) {
                            PROFILE_PIC_COUNT = 0;
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
                next1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (etf.length() >= 1 && etm.length() >= 1 && etl.length() >= 1 && eth.length() >= 1 && ets.length() >= 1 && ethi.length() >= 1 && etb.length() >= 1 && ete.length() >= 1 && etp.length() >= 1 && etcd.length() >= 1 && etei.length() >= 1 && etcs.length() >= 1) {
                            startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                        } else {
                            Toast.makeText(FirstActivity.this, "Please enter the all field", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }


        });


    }

    private void invitViews() {
        date = (TextView) findViewById(R.id.date);
        etf = (EditText) findViewById(R.id.etf);
        pic = (Button) findViewById(R.id.pic);
        next1 = (Button) findViewById(R.id.bt_next1);
        etm = (EditText) findViewById(R.id.etm);
        etl = (EditText) findViewById(R.id.etl);
        eth = (EditText) findViewById(R.id.eth);
        ets = (EditText) findViewById(R.id.ets);
        ethi = (EditText) findViewById(R.id.ethi);
        etb = (EditText) findViewById(R.id.etb);
        ete = (EditText) findViewById(R.id.ete);
        etp = (EditText) findViewById(R.id.etp);
        etcd = (EditText) findViewById(R.id.etcd);
        etei = (EditText) findViewById(R.id.etei);
        etcs = (EditText) findViewById(R.id.etcs);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.iv1);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        } else if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK && null != data) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView imageView = (ImageView) findViewById(R.id.iv1);
            imageView.setImageBitmap(photo);
           /* Uri selectedImage1 =data.getData();
            String[] filecamera ={MediaStore.Images.Media.DATA};

            Cursor cursor1 =getContentResolver().query(selectedImage1,filecamera,null,null,null);
            cursor1.moveToFirst();

            int columnIndex1 =cursor1.getColumnIndex(filecamera[0]);
            String camerapath =cursor1.getString(columnIndex1);
            cursor1.close();

            ImageView imageView = (ImageView) findViewById(R.id.iv);
            imageView.setImageBitmap(BitmapFactory.decodeFile(camerapath));*/
        }

    }
}



