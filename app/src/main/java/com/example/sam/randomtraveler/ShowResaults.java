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

    public String Daysfrom, Daysto, Price, From;
    public String Resaults="";
    public String [] data;
    public String json_string;
    JSONObject  jsonObject;
    JSONArray jsonArray;
    InfoAdapter infoAdapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_resaults);
        listView = (ListView) findViewById(R.id.listview);
        infoAdapter = new InfoAdapter(this,R.layout.row_layout);
        listView.setAdapter(infoAdapter);
        Intent intent = getIntent();
        Daysfrom = intent.getStringExtra("daysf");
        Daysto = intent.getStringExtra("daysto");
        Price = intent.getStringExtra("price");
        From = intent.getStringExtra("from");
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

            //textView.setText(o.toString());
            json_string=o.toString();
            try {

                jsonObject = new JSONObject(json_string);
                jsonArray = jsonObject.getJSONArray("data");

                int count = 0;
                String from,to,price,dateFrom,dateTo;
                while(count <jsonArray.length())
                {
                    JSONObject JO = jsonArray.getJSONObject(count);
                    from = JO.getString("cityFrom");
                    to = JO.getString("cityTo");
                    price = JO.getString("price");
                    dateFrom = JO.getString("dTimeUTC");
                    dateTo = JO.getString("dTimeUTC");
                    Info info = new Info(from,to,price,dateFrom,dateTo);

                    infoAdapter.add(info);

                    count++;


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


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
