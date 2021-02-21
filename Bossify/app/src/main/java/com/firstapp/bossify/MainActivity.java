package com.firstapp.bossify;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firstapp.bossify.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;

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


        try {
            Model model = Model.newInstance(context);

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 7}, DataType.FLOAT32);
            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            // TODO Handle the exception
        }


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

