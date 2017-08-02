package com.example.cpu11341_local.userviewtest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    String[] items = {"Chat", "Yêu thích", "Giờ lên sóng", "Giờ xem", "Bình chọn"};
    Integer[] imgid = {R.drawable.chat, R.drawable.love, R.drawable.time, R.drawable.view, R.drawable.vote};

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Dataprovider> arrayList = new ArrayList<Dataprovider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        int i=0;
        for (String name : items){
            Dataprovider dataprovider = new Dataprovider(imgid[i], items[i]);
            arrayList.add(dataprovider);
            i++;
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Dataprovider item) {
                if (item.getItemName()=="Bình chọn") {
                    Intent myIntent=new Intent(getApplicationContext(), VoteActivity.class);
                    startActivity(myIntent);
                }
                if (item.getItemName()=="Giờ xem") {
                    Intent myIntent=new Intent(getApplicationContext(), ViewTimeActivity.class);
                    startActivity(myIntent);
                }

            }
        });
    }
}
