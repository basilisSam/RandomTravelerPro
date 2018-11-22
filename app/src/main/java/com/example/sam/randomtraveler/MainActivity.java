package com.example.sam.randomtraveler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText from,daysFrom,daysTo,price;
    Spinner passengers;
    public static final String TAG_NAME = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String pass[] = {"1","2","3","4"};
        from=(EditText)findViewById(R.id.FromInput);
        daysFrom=(EditText)findViewById(R.id.MinDays);
        daysTo=(EditText)findViewById(R.id.MaxDays);
        price=(EditText)findViewById(R.id.PriceInput);
        passengers = (Spinner)findViewById(R.id.spinner);
        final Button button = findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,pass);
        passengers.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor = getSharedPreferences(TAG_NAME,MODE_PRIVATE).edit();
                editor.putString("from",from.getText().toString());
                editor.putString("daysf",daysFrom.getText().toString());
                editor.putString("daysto",daysTo.getText().toString());
                editor.putString("price",price.getText().toString());
                editor.apply();

               Intent intent = new Intent(MainActivity.this, ShowResaults.class);
              //  intent.putExtra("From",from.getText().toString());
               // intent.putExtra("daysf",daysFrom.getText().toString());
                //intent.putExtra("daysto",daysTo.getText().toString());
                //intent.putExtra("price",price.getText().toString());

                startActivity(intent);


            }
        });
    }
}
