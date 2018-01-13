package com.example.rathana.adapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowListView(View view) {
        startActivity(new Intent(this,ListViewActivity.class));
    }

    public void onShowRecyclerView(View view) {

    }

    public void onShowGridView(View view) {
        startActivity(new Intent(this,GridViewActivity.class));
    }
}
