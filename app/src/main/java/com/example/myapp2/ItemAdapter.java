package com.example.myapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder2>{
Context context;
ArrayList<Item> list;

    public ItemAdapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {

          Item item = list.get(position);
          holder.Category.setText(item.getCategory());
          holder.Item1.setText(item.getItem1());
          holder.Item2.setText(item.getItem2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{

TextView Category, Item1, Item2;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            Category = itemView.findViewById(R.id.categoryName);
            Item1 = itemView.findViewById(R.id.item1);
            Item2 = itemView.findViewById(R.id.item2);
        }
    }
}
