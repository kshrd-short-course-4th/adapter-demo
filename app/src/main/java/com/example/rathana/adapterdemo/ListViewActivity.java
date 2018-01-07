package com.example.rathana.adapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rathana.adapterdemo.adapter.SongAdapter;
import com.example.rathana.adapterdemo.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private String[] myArray;
    private List<Song> list=new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private SongAdapter songAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        myArray=getResources().getStringArray(R.array.my_array);

       /* arrayAdapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myArray
        );*/

       songAdapter=new SongAdapter(this,list);
        mListView=findViewById(R.id.listView);
        mListView.setAdapter(songAdapter);
        //set event to listView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /*goToDetail(myArray[position]);
                Toast.makeText(ListViewActivity.this,""+ myArray[position],
                        Toast.LENGTH_SHORT).show();*/
            }
        });
        setSongItems();

    }

    void goToDetail(String s){
        Intent i= new Intent(this,DetailActivity.class);
        i.putExtra("DATA", s );
        startActivity(i);
    }

    private  void setSongItems(){
        for(int i=0;i<50;i++){
            if(i==1){
                this.list.add(new Song("Song 1","Preap Sovath",true));
            }else{
                this.list.add(new Song("Song "+i,"Preap Sovath",false));
            }
        }
        songAdapter.setSongItems(this.list);

    }


}
