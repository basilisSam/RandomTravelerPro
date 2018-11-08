package com.example.sam.randomtraveler;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
   // FetchApi f= new FetchApi();

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
        //f.execute();

    }

    /*
    private class FetchApi extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.skypicker.com/flights?fly_from="+From+"&price_to="+Price
                        +"&nights_in_dst_from="+Daysfrom
                        +"&nights_in_dst_to="+Daysto
                        +"&type_flights=lcc");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                InputStream inputs = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputs));
                String line = "";
                StringBuilder sb= new StringBuilder();

                //for Vodka
                while((line=br.readLine())!= null){
                    sb.append(line+"\n");
                }
                inputs.close();
                Resaults=sb.toString();


            }catch (Exception e){
                e.printStackTrace();
            }

            //try parse json data
            try{
                JSONArray ja=new JSONArray(Resaults);
                JSONObject jo=null;
                data=new String[ja.length()];


                for (int i=0;i<=ja.length();i++){
                    jo=ja.getJSONObject(i);
                    data[i]="Απο"+" "+jo.getString("cityFrom")+" "+"Για"+" "+jo.getString("cityΤο");
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            list.setAdapter(new ArrayAdapter<String>(ShowResaults.this,android.R.layout.simple_expandable_list_item_1,data));
        }
    }
    */

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

            try{
                JSONArray ja=new JSONArray(response.body().string());
                JSONObject jo=null;
                data=new String[ja.length()];


                for (int i=0;i<=ja.length();i++){
                    jo=ja.getJSONObject(i);
                    data[i]="Απο"+" "+jo.getString("cityFrom")+" "+"Για"+" "+jo.getString("cityΤο");
                }


            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {


            list.setAdapter(new ArrayAdapter<String>(ShowResaults.this,android.R.layout.simple_expandable_list_item_1,data));

           // textView.setText(data.toString());



        }
    }.execute();

}
