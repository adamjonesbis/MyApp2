package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
//See references.txt to get see where code was taken from
public class prepView2 extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<ListModel> listModels = new ArrayList<>();
    int[] listImages = {R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24,R.drawable.baseline_menu_book_24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep_view2);
        RecyclerView recyclerview = findViewById(R.id.mRecyclerView);
        setListModels();
        Lists_RecyclerViewAdapter adapter = new Lists_RecyclerViewAdapter(this, listModels, this);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setListModels(){
        String[] listNames = getResources().getStringArray(R.array.lists_full_txt);
        String[] listDescriptions = getResources().getStringArray(R.array.lists_full_des);
        for (int i = 0; i<listNames.length; i++){
    listModels.add(new ListModel(listNames[i],listImages[i],listDescriptions[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
Intent intent = new Intent(prepView2.this, Categories.class);
intent.putExtra("Name", listModels.get(position).getListName());
intent.putExtra("Description",listModels.get(position).getDescription());

startActivity(intent);
    }
}