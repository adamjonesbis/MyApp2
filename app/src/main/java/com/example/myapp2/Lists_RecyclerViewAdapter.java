package com.example.myapp2;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Lists_RecyclerViewAdapter extends RecyclerView.Adapter<Lists_RecyclerViewAdapter.MyViewHolder> {
private final RecyclerViewInterface recyclerViewInterface;
   Context context;
   ArrayList<ListModel> listModels;

    public Lists_RecyclerViewAdapter (Context context, ArrayList<ListModel> listModels,
                                      RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.listModels = listModels;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public Lists_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new Lists_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Lists_RecyclerViewAdapter.MyViewHolder holder, int position) {
    holder.tvName.setText(listModels.get(position).getListName());
        holder.imageView.setImageResource(listModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
            tvName = itemView.findViewById(R.id.textview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos !=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);


                        }
                    }
                }
            });
        }
    }
}
