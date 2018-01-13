package com.example.rathana.adapterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.adapterdemo.R;
import com.example.rathana.adapterdemo.entity.Product;
import com.squareup.picasso.Picasso;

import java.net.PortUnreachableException;
import java.util.List;

/**
 * Created by RATHANA on 1/13/2018.
 */

public class ProductAdapter extends BaseAdapter{
    private List<Product> list;
    private Context context;
    public void setProductItems(List<Product> list){
        this.list=list;
        notifyDataSetChanged();
    }
    public ProductAdapter (Context context,List<Product> list){
        this.list=list;
        this.context=context;
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
            view= LayoutInflater.from(context).inflate(
                    R.layout.grid_item_layout,parent,false
            );
        }else {
            view=convertView;
        }

        ImageView image=view.findViewById(R.id.image);
        TextView title=view.findViewById(R.id.title);
        Product product=list.get(position);
        if(list!=null || !list.isEmpty()){
            if(product.getImage()!=0) {
                Picasso.with(context)
                        .load(product.getImage())
                        .resize(50,50)
                        .into(image);
            }
            if(product.getTitle()!=null) title.setText(product.getTitle());
        }
        return view;
    }
}
