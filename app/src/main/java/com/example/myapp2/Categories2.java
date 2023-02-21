package com.example.myapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.ArrayList;
//See references.txt to get see where code was taken from
//https://www.youtube.com/watch?v=7GPUpvcU1FE&ab_channel=PracticalCoding - recycler view interface to new activty
//https://www.youtube.com/watch?v=Mc0XT58A1Z4&ab_channel=PracticalCoding- recycler view
public class Categories2 extends AppCompatActivity {

    RecyclerView recyclerview;
    DatabaseReference database;
    ItemAdapter myAdapter;
    ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories2);

        recyclerview = findViewById(R.id.itemlist);
        database = FirebaseDatabase.getInstance().getReference("Prep");
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new ItemAdapter(this,list);
        recyclerview.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                Item item = dataSnapshot.getValue(Item.class);
                list.add(item);

            }

            myAdapter.notifyDataSetChanged();
        }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}