package com.example.rathana.adapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rathana.adapterdemo.adapter.SongAdapter;
import com.example.rathana.adapterdemo.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity
implements SongAdapter.CallBack{
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
            startActivity(new Intent(ListViewActivity.this,DetailActivity.class));
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


    @Override
    public void getItemPosition(int position) {
        Song s=list.get(position);
        //Song newSong=null;
        if(s.isPlaying()){
            s.setPlaying(false);
        }else{
            s.setPlaying(true);
        }
        list.set(position,s);

        int playingPos=getPlayingSongPosition(list);

        if(playingPos!=-1){
            Song playingItem=list.get(playingPos);
            playingItem.setPlaying(false);
            list.set(playingPos,playingItem);
        }
        songAdapter.setSongItems(this.list);
        songAdapter.notifyDataSetChanged();
        Log.e("SongAdapter Callback", "playing pos "+playingPos);
        Log.e("SongAdapter Callback", "getItemPosition: "+s.isPlaying());
        Log.e("SongAdapter Callback", "getItemPosition: "+position);
    }

    private int getPlayingSongPosition(List<Song> songs){
        for(int p=0;p<songs.size();p++){
            if(songs.get(p).isPlaying()){
                return p;
            }
        }
        //if on item is playing return -1
        return -1;
    }
}
