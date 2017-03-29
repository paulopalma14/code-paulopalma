package com.ipbeja.estig.packagetracker3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOpenCarrier(View view) {

        Intent intent = new Intent(this, CarrierActivity.class);
        startActivity(intent);

    }

    public void btnValidatenNumber(View view) {

        EditText nr = (EditText) findViewById(R.id.mainInTxt);
        TrackingNumber trackingNumber = new TrackingNumber(this, readFileCountry());

        if(trackingNumber.validTrackingNumber(nr.getText().toString())){
            Toast.makeText(this, "TrackingNumber is Valid", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "TrackingNumber is not Valid", Toast.LENGTH_SHORT).show();
        }

    }

    public List<String> readFileCountry() {
        List<String> cty = new ArrayList<>();

        InputStreamReader inreader = null;
        try {
            inreader = new InputStreamReader(this.getAssets().open("txt/postorigncodes.txt"));

            BufferedReader reader = new BufferedReader(inreader);
            String line;
            while ((line = reader.readLine()) != null) {

                String[] split = line.split("\t");
                cty.add(split[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return cty;
    }


    public void btnOpenCheckpoint(View view) {


    }

    public void btnDelivery(View view) {


    }
}
