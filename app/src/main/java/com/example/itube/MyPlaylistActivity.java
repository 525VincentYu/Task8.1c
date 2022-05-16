package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MyPlaylistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String>urllist;
    Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_playlist);
        DB = new Database(this);

        urllist = new ArrayList<>();
        if(DB.getAlldata()==null){}
        else {
            urllist = DB.getAlldata1();}
        recyclerView = findViewById(R.id.re);
        MyAdapter adapter = new MyAdapter(this,urllist);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}