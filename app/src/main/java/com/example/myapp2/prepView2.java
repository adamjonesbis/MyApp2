package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class prepView2 extends AppCompatActivity {

    ArrayList<ListModel> listModels = new ArrayList<>();
    int[] listImages = {R.drawable.ic_baseline_fastfood_24, R.drawable.ic_baseline_local_drink_24, R.drawable.ic_baseline_change_circle_24, R.drawable.ic_baseline_qr_code_scanner_24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep_view2);
        RecyclerView recyclerview = findViewById(R.id.mRecyclerView);
        setListModels();
        Lists_RecyclerViewAdapter adapter = new Lists_RecyclerViewAdapter(this, listModels);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setListModels(){
        String[] listNames = getResources().getStringArray(R.array.lists_full_txt);

        for (int i = 0; i<listNames.length; i++){
    listModels.add(new ListModel(listNames[i],listImages[i]));
        }
    }
}