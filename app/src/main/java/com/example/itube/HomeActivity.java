package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    EditText url;
    Button play, add, myplaylist;
    Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        DB = new Database(this);
        url = findViewById(R.id.url);
        play = findViewById(R.id.play);
        add = findViewById(R.id.add);
        myplaylist = findViewById(R.id.myplaylist);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),playActivity.class);
                intent.putExtra("key",url.getText().toString());
                startActivity(intent);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.insertData(url.getText().toString());
            }
        });
        myplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MyPlaylistActivity.class);
                startActivity(intent);
            }
        });
    }
}