package com.diffy.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class popup extends AppCompatActivity {

    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        details = (TextView) findViewById(R.id.details);
        Intent getDta = getIntent();
        Bundle bmiData = getDta.getBundleExtra("loginDta");
        String data = bmiData.getString("data");
        details.setText(data);
    }
}