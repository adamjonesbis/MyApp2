package com.example.myapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// code from https://www.youtube.com/watch?v=DWIGAkYkpg8&ab_channel=AndroidKnowledge
public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder4> {

    private Context context;
    private List<DataClass2> dataList;

    public MyAdapter3(Context context, List<DataClass2> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem2, parent, false);
        return new MyViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder4 holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        // holder.recLang.setText(dataList.get(position).getDataLang());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivtiy2.class);

                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Key", dataList.get(holder.getAdapterPosition()).getKey());
                intent.putExtra("Language", dataList.get(holder.getAdapterPosition()).getDataLang());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }


    class MyViewHolder4 extends RecyclerView.ViewHolder {
        ImageView recImage;
        TextView recTitle, recDesc, recLang;
        CardView recCard;

        public MyViewHolder4(@NonNull View itemView) {
            super(itemView);
            recImage = itemView.findViewById(R.id.recImage);
            recCard = itemView.findViewById(R.id.recCard);
            recDesc = itemView.findViewById(R.id.recDesc);
            //recLang = itemView.findViewById(R.id.recLang);
            recTitle = itemView.findViewById(R.id.recTitle);
        }
    }

}
