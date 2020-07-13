package com.example.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView textView=(TextView) findViewById(R.id.textID);
        Intent intent = getIntent();
        String nomvar = intent.getStringExtra("text");
        textView.setText(nomvar);



    }
}
