package materialtest.example.vishal.materialdesign.activity;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import materialtest.example.vishal.materialdesign.R;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    public GridView grid;
    public String[] web = {
            "Add Information", "Members","Change Password"};
    public int[] imageId = {
            R.drawable.imgres, R.drawable.members, R.drawable.password_change};
    /* PopupWindow popupWindow;
     private PopupWindow pwindo;*/
    Dialog dialog;

    public Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dialog = new Dialog(this);
        //     popupWindow = new PopupWindow(this);

        ImageAdapter adapter = new ImageAdapter(this, web, imageId);
        grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {  //showPopup();
                    showDialog();
                }
                else if(position == 1){
                    startActivity(new Intent(LaunchActivity.this,MemberActivity.class));
                }else if(position==2){
                    startActivity(new Intent(LaunchActivity.this,ChangePasswordActivity.class));
                }

            }
        });


    }

    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(LaunchActivity.this);
        LayoutInflater inflater = (LayoutInflater) LaunchActivity.this.getLayoutInflater();
        View view = inflater.inflate(R.layout.popup, (ViewGroup) findViewById(R.id.popup));
        builder.setView(view);
        dialog = builder.create();
        dialog.show();

        TextView t1 = (TextView) view.findViewById(R.id.tv_android);
        TextView t2 = (TextView) view.findViewById(R.id.tv_back);
        TextView t3 = (TextView) view.findViewById(R.id.tv_ios);
        TextView t4 = (TextView) view.findViewById(R.id.tv_web);
        TextView t5 = (TextView) view.findViewById(R.id.tv_xam);
        TextView t6 = (TextView) view.findViewById(R.id.tv_mar);

        t1.setOnClickListener(LaunchActivity.this);
        t2.setOnClickListener(LaunchActivity.this);
        t3.setOnClickListener(LaunchActivity.this);
        t4.setOnClickListener(LaunchActivity.this);
        t5.setOnClickListener(LaunchActivity.this);
        t6.setOnClickListener(LaunchActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_android:
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
                dialog.dismiss();
                break;
            case R.id.tv_back:
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
                dialog.dismiss();
                break;
            case R.id.tv_ios:
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
                dialog.dismiss();
                break;
            case R.id.tv_web:
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
                dialog.dismiss();
                break;
            case R.id.tv_xam:
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
                dialog.dismiss();
                break;
            case R.id.tv_mar:
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
                dialog.dismiss();
                break;


        }

    }

}



   /* private void showPopup() {
        LayoutInflater inflater = (LayoutInflater) LaunchActivity.this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup,
                (ViewGroup) findViewById(R.id.popup));
        pwindo = new PopupWindow(layout, ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT, true);
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
        pwindo.setOutsideTouchable(true);

        pwindo.setBackgroundDrawable(new BitmapDrawable());
        final Spinner sp1 = (Spinner) layout.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adp1 = ArrayAdapter.createFromResource(this, R.array.stra1, android.R.layout.simple_list_item_1);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adp1);

        ok = (Button) layout.findViewById(R.id.bt_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchActivity.this, FirstActivity.class));
            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ss = sp1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


        });


    }*/



