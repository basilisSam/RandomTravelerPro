package com.example.sam.randomtraveler;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowResaults extends AppCompatActivity {
    public ListView list;
    public String Daysfrom, Daysto, Price, From;
    public String Resaults="";
    public String [] data;
    public TextView textView ;
    public String json_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_resaults);
        int a=0;
        textView = findViewById(R.id.testShow);
        Intent intent = getIntent();
        Daysfrom = intent.getStringExtra("daysf");
        Daysto = intent.getStringExtra("daysto");
        Price = intent.getStringExtra("price");
        From = intent.getStringExtra("From");
        list= (ListView)findViewById(R.id.printList);


    }



     AsyncTask asyncTask = new AsyncTask() {



        @Override
        protected Object doInBackground(Object[] objects) {


            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.skypicker.com/flights?fly_from="+From+"&price_to="+Price+"&nights_in_dst_from="+Daysfrom+"&nights_in_dst_to="+Daysto+"&type_flights=lcc").build();

            Response response = null;

            try{

                response = client.newCall(request).execute();
                return response.body().string();


            }catch (IOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {

            textView.setText(o.toString());
            json_string=o.toString();





        }
    }.execute();

public void parseJSON(View view){
    if(json_string==null){
        Toast.makeText(getApplicationContext(),"Not Found",Toast.LENGTH_LONG).show();
    }
    else
    {
        Intent intent = new Intent (this,ShowResaults.class);
        intent.putExtra("json_data",json_string);
        startActivity(intent);
    }
    }
}
