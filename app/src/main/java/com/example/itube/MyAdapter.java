package com.example.itube;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<String>urllist = new ArrayList<String>();


    public MyAdapter(Context context, ArrayList<String> urllist) {
        this.context = context;
        this.urllist = urllist;



    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.layout, null);
        MyViewHolder myViewHoder = new MyViewHolder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       String url = urllist.get(position);

       holder.urls.setText(url);




    }

    @Override
    public int getItemCount() {
        return urllist.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView urls;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            urls = itemView.findViewById(R.id.url1);



        }


    }
}
