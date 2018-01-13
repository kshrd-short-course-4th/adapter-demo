package com.example.rathana.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.rathana.adapterdemo.adapter.ProductAdapter;
import com.example.rathana.adapterdemo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    private List<Product> list =new ArrayList<>();
    private ProductAdapter adapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        setUpGridView();
    }

    private void setUpGridView() {
        gridView=findViewById(R.id.gridView);
        adapter=new ProductAdapter(this,this.list);
        gridView.setAdapter(adapter);
        setProductItems();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }
                Toast.makeText(GridViewActivity.this, ""+list.get(position).getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private  void setProductItems(){
        /*for(int i=0;i<50;i++){
            if(i%2==0)
            this.list.add(new Product(R.drawable.banana,"Banana "+i));
            else
                this.list.add(new Product(R.drawable.apple,"Banana "+i));
        }*/

        this.list.add(new Product(R.drawable.apple,"apple "));
        this.list.add(new Product(R.drawable.banana,"banana "));
        this.list.add(new Product(R.drawable.orange,"orange "));

        this.list.add(new Product(R.drawable.apple,"apple "));
        this.list.add(new Product(R.drawable.banana,"banana "));
        this.list.add(new Product(R.drawable.orange,"orange "));

        this.list.add(new Product(R.drawable.apple,"apple "));
        this.list.add(new Product(R.drawable.banana,"banana "));
        this.list.add(new Product(R.drawable.orange,"orange "));
        adapter.setProductItems(this.list);
    }
}
