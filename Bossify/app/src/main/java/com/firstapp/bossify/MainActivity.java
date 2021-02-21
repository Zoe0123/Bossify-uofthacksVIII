package com.firstapp.bossify;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String software2;
    int experienceLevel2, rating2, hour2;
    //will store the estimate
    static String EXTRADATA;

    private Button next;
    private EditText experienceLevel, rating, hour, software;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get input
        experienceLevel = (EditText)findViewById(R.id.editTextTextPersonName21);
        rating = (EditText)findViewById(R.id.editTextTextPersonName22);
        hour = (EditText)findViewById(R.id.editTextTextPersonName19);
        software = (EditText)findViewById(R.id.editTextTextPersonName16);

        //button
        next = (Button)findViewById(R.id.button);
        software2 = software.getText().toString();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                experienceLevel2 = Integer.valueOf(experienceLevel.getText().toString());
                rating2 = Integer.valueOf(rating.getText().toString());
                hour2 = Integer.valueOf(hour.getText().toString());
                openNextAppPage();
            }
        });




    }
    public void openNextAppPage(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}

