package com.example.rathana.adapterdemo.adapter;

import android.app.ListActivity;
import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.adapterdemo.ListViewActivity;
import com.example.rathana.adapterdemo.R;
import com.example.rathana.adapterdemo.entity.Song;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by RATHANA on 1/7/2018.
 */

public class SongAdapter extends BaseAdapter{
    private List<Song> list;
    private Context context;
    private Song song;
    private CallBack callBack;
    public SongAdapter(Context context, List<Song> list){
        this.context=context;
        this.list=list;
        callBack= (CallBack) context;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=null;
        if(convertView==null){
            view=LayoutInflater.from(context).inflate(
                    R.layout.sustom_adapter_layout,
                    parent,
                    false
            );
        }else{
            view=convertView;
        }
        final ImageView mSongImage,mPlay;
        TextView mTitle,mAuthor;

        //get reference object form xml layout
        mSongImage=view.findViewById(R.id.image);
        mAuthor=view.findViewById(R.id.author);
        mPlay=view.findViewById(R.id.btnPlayStatus);
        mTitle=view.findViewById(R.id.title);

        //bind data to item layout

        if(this.list!=null || !this.list.isEmpty()){
            song=this.list.get(position);
            if(song.getTitle()!=null)
                mTitle.setText(song.getTitle());
            if(song.getAuthor()!=null)
                mAuthor.setText(song.getAuthor());
            if(song.isPlaying()){
                mPlay.setImageResource(R.drawable.play_button);
            }else mPlay.setImageResource(R.drawable.pause);
        }

        //add event handling to view in list item
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.getItemPosition(position);
                Log.e("SongAdapter", "onClick: "+ position);
            }
        });
        return view;
    }
    public interface CallBack{
        void getItemPosition(int position);
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
    public void setSongItems(List<Song> list){
        this.list=list;
        notifyDataSetChanged();
    }
}
