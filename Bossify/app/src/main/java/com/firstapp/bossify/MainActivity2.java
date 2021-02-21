package com.firstapp.bossify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.textView3);
        Intent intent = getIntent();
        String estimate = intent.getStringExtra(MainActivity.EXTRADATA);
        //print estimate on the screen
       // textView.setText(estimate);

    }
}