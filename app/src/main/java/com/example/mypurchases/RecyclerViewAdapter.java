package com.example.mypurchases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.addviewHolder> {
    ArrayList<product> pro ;
    public RecyclerViewAdapter(ArrayList<product> pro) {
        this.pro = pro;
    }



    @NonNull
    @Override
    public addviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(lp);
        return new addviewHolder(v);
        //addviewHolder addviewHolder = new addviewHolder(v);
        //return addviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull addviewHolder holder, int position) {
        product product = pro.get(position);
        holder.tv_type.setText(product.getType());




    }


    @Override
    public int getItemCount() {
        return pro.size();
    }


    public class addviewHolder extends RecyclerView.ViewHolder{
        TextView tv_type ;


        public addviewHolder(@NonNull View itemView) {
            super(itemView);
            tv_type = itemView.findViewById(R.id.add_tv);


        }
    }
}

