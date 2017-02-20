package materialtest.example.vishal.materialdesign.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import materialtest.example.vishal.materialdesign.R;

public class MemberActivity extends AppCompatActivity {

    /*String[] mobileArray = {"Vishal","jayesh","jaydeep","Jainish","Deeksheet Sir","Tarun Sir","ishita","Tejashree","Kashyap","Karuna","Vatsl","Abdali","basavaraj"
    ,"niyaj","saubhagya","vani","amrin"};*/
    private ProgressDialog pDialog;
    private String TAG = MemberActivity.class.getSimpleName();
    private static String url = "https://jsonblob.com/api/9723c1ad-f27f-11e6-901d-6b6d0b37dc92";
    ArrayList<HashMap<String, String>> contactList;
    ListView listView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // ArrayAdapter arrayAdapter = new ArrayAdapter(MemberActivity.this,R.layout.list_view,mobileArray);
        listView = (ListView) findViewById(R.id.mobile_list);
        contactList = new ArrayList<>();
        new GetContacts().execute();
       // listView.setAdapter(arrayAdapter);
    }
        private class GetContacts extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... arg0) {
                HttpHandler sh = new HttpHandler();

                // Making a request to url and getting response
                String jsonStr = sh.makeServiceCall(url);

                Log.e(TAG, "Response from url: " + jsonStr);

                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);

                        // Getting JSON Array node
                        JSONArray contacts = jsonObj.getJSONArray("contacts");

                        // looping through All Contacts
                        for (int i = 0; i < contacts.length(); i++) {
                            JSONObject c = contacts.getJSONObject(i);

                            String id = c.getString("id");
                            /*String name = c.getString("name");
                            String email = c.getString("email");
                            String address = c.getString("address");
                            String gender = c.getString("gender");*/

                            // Phone node is JSON Object
                            /*JSONObject phone = c.getJSONObject("phone");
                            String mobile = phone.getString("mobile");
                            String home = phone.getString("home");
                            String office = phone.getString("office");*/

                            // tmp hash map for single contact
                            HashMap<String, String> contact = new HashMap<>();

                            // adding each child node to HashMap key => value
                            contact.put("id", id);
                            /*contact.put("name", name);
                            contact.put("email", email);
                            contact.put("mobile", mobile);*/

                            // adding contact to contact list
                            contactList.add(contact);
                        }
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });

                    }
                } else {
                    Log.e(TAG, "Couldn't get json from server.");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Couldn't get json from server. Check LogCat for possible errors!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }




                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                // Dismiss the progress dialog
              /* if (pDialog.isShowing()){
                    pDialog.dismiss();}*/
                /**
                 * Updating parsed JSON data into ListView
                 * */
                ListAdapter adapter = new SimpleAdapter(
                        MemberActivity.this, contactList,
                        R.layout.list_view, new String[]{"id"}, new int[]{R.id.label1});

                listView.setAdapter(adapter);
            }
        }

}
