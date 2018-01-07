package com.example.rathana.adapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mMessage=findViewById(R.id.detailMessage);
        Intent intent=getIntent();
        if(intent!=null){
            String s=intent.getStringExtra("DATA");
            mMessage.setText(s);
        }

    }
}
