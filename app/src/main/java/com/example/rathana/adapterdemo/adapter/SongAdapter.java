package com.example.rathana.adapterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.adapterdemo.R;
import com.example.rathana.adapterdemo.entity.Song;

import java.util.List;

/**
 * Created by RATHANA on 1/7/2018.
 */

public class SongAdapter  extends BaseAdapter{
    private List<Song> list;
    private Context context;

    public SongAdapter(Context context, List<Song> list){
        this.context=context;
        this.list=list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
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
        ImageView mSongImage,mPlay;
        TextView mTitle,mAuthor;

        //get reference object form xml layout
        mSongImage=view.findViewById(R.id.image);
        mAuthor=view.findViewById(R.id.author);
        mPlay=view.findViewById(R.id.btnPlayStatus);
        mTitle=view.findViewById(R.id.title);

        //bind data to item layout
        if(this.list!=null || !this.list.isEmpty()){
            Song song=this.list.get(position);
            if(song.getTitle()!=null)
                mTitle.setText(song.getTitle());
            if(song.getAuthor()!=null)
                mAuthor.setText(song.getAuthor());
            if(song.isPlaying()){
                mPlay.setImageResource(R.drawable.play_button);
            }else mPlay.setImageResource(R.drawable.pause);
        }
        return view;
    }

    public void setSongItems(List<Song> list){
        this.list=list;
        notifyDataSetChanged();
    }
}
