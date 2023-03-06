package com.example.myapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    List<DataClass2> dataList2;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    MyAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);




        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity3.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList2 = new ArrayList<>();

        adapter = new MyAdapter3(MainActivity3.this, dataList2);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Android tutorials2");
        dialog.show();

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList2.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    DataClass2 dataClass = itemSnapshot.getValue(DataClass2.class);
                    dataClass.setKey(itemSnapshot.getKey());
                    dataList2.add(dataClass);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, UploadActivity2.class);
                startActivity(intent);
            }
        });

    }}