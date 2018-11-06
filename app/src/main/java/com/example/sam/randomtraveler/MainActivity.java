package com.example.sam.randomtraveler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText From,Daysfrom,DaysTo,Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        From=(EditText)findViewById(R.id.From);
        Daysfrom=(EditText)findViewById(R.id.Daysto);
        DaysTo=(EditText)findViewById(R.id.editText3);
        Price=(EditText)findViewById(R.id.Price);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO IF EMPTY ERROR
                //Den mporeis na peraseis alliws value apo thn mia klash sthn allh sto android
                //ginete me 3 tropous o enas einai autos o allos na ths kaneis static alla dn einai kalo gia to programma krasarei
                //thelw na deis an tis pernaei alliws tha to kanoume me sharedpref den mporw na to tre3w
                Intent intent = new Intent(MainActivity.this, ShowResaults.class);
                intent.putExtra("from", From.getText().toString());
                intent.putExtra("Fday", Daysfrom.getText().toString());
                intent.putExtra("Tday", DaysTo.getText().toString());
                intent.putExtra("Price", Price.getText().toString());

            }
        });
    }
}
