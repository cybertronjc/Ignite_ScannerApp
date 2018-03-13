package com.jagdishchoudhary.ignite;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import dmax.dialog.SpotsDialog;

public class ResultActivity extends AppCompatActivity {
    private  TextView txtId, txtName;
    private String id, name,eventName ;
    private SpotsDialog mProgress;
    private URL url;
    private List<User> userList;

    private Button btnMark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtName = (TextView)findViewById(R.id.txtName);
        btnMark = (Button)findViewById(R.id.btnMark);
        txtId = (TextView)findViewById(R.id.txtId);
        final String codeStr = getIntent().getStringExtra("code");
        //code.setText(codeStr);

        mProgress = new SpotsDialog(this);
        mProgress.setMessage("Marking Attendance");
        eventName = ((Loading)getApplication()).getEventName();

        userList = (ArrayList<User>) ((Loading)getApplication()).getUserList();
        //Toast.makeText(this, Integer.toString(userList.size()), Toast.LENGTH_SHORT).show();
        for (int i = 0; i< userList.size(); i++){
            //Toast.makeText(this, Integer.toString(userList.get(i).getId()), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, Integer.toString(((Loading)getApplication()).getChildCount()), Toast.LENGTH_SHORT).show();
            if (codeStr.equals(Integer.toString(userList.get(i).getId()))){
                id = Integer.toString(userList.get(i).getId());
                name = userList.get(i).getName();
                txtName.setText(name);
                txtId.setText(id);
                //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            }
        }
        btnMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.isNetworkAvailable(ResultActivity.this)){
                    new SendRequest().execute();
                }
                else {
                    Toast.makeText(ResultActivity.this, "Check your connection and try again", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute(){
            mProgress.show();
        }

        protected String doInBackground(String... arg0) {

            try{

                if (eventName.equals("Energy")){
                    try {
                        url = new URL("https://script.google.com/macros/s/AKfycbx37CuwQyUX08ciuUL7kuDkBWdwK5vK7qKtPNtgnC20JtKX_5B-/exec");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                if (eventName.equals("Microsoft")){
                    try {
                        url = new URL("https://script.google.com/macros/s/AKfycbxMIniohuUt0QyIexmx1wTtsarS2r5y8QZ_0-63SwbHSyXjqhYR/exec");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                if (eventName.equals("Water")){
                    try {
                        url = new URL("https://script.google.com/macros/s/AKfycby6efp-QF-Z-s3msyR3LLCMGSZJMnnksjSt9nEHKXFbgfyAx9g/exec");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                if (eventName.equals("Material")){
                    try {
                        url = new URL("https://script.google.com/macros/s/AKfycbwybN1aH82087tzip9i_gpOI1lYb35MxPj-kTGP2dNQkNzdkyl9/exec");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                if (eventName.equals("Instru")){
                    try {
                        url = new URL("https://script.google.com/macros/s/AKfycby-ARRR6uoZrIy6GW6dTHT50fwEkvQYgR-OdTotRYChIb5T7x8/exec");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }
                if (eventName.equals("Photonics")){
                    try {
                        url = new URL("https://script.google.com/macros/s/AKfycbzRlyR5W7LVBsQTie2LYuf0CGVjQpl34W83Uu1uQKZ-Abkgg2Pn/exec");

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }

                //URL url = new URL("https://script.google.com/macros/s/AKfycbx37CuwQyUX08ciuUL7kuDkBWdwK5vK7qKtPNtgnC20JtKX_5B-/exec");
                // https://script.google.com/macros/s/AKfycbyuAu6jWNYMiWt9X5yp63-hypxQPlg5JS8NimN6GEGmdKZcIFh0/exec
                //URL url = ((Loading)getApplication()).getUrl();
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);


                postDataParams.put("Id",id);
                postDataParams.put("Name",name);


                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(30000 /* milliseconds */);
                conn.setConnectTimeout(30000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

            mProgress.dismiss();

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();


        }
    }


    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
}
