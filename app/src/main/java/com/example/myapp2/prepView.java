package com.example.myapp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class prepView extends AppCompatActivity {

    ListView myListView;
    ListView myListView2;
    RecyclerView recycleview1;
    ArrayList<String> myArrayList = new ArrayList<>();
    ArrayList<String> myArrayList2 = new ArrayList<>();
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prep_view);

        ArrayAdapter<String> myArrayadapter = new ArrayAdapter<String>(prepView.this,android.R.layout.simple_list_item_1,myArrayList);

        myListView = (ListView) findViewById(R.id.listview1);
        myListView.setAdapter(myArrayadapter);
        mRef = FirebaseDatabase.getInstance().getReference("Prep");


        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                String value=dataSnapshot.getValue().toString();
                myArrayList.add(value);
                myArrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ArrayAdapter<String> myArrayadapter2 = new ArrayAdapter<String>(prepView.this,android.R.layout.simple_list_item_1,myArrayList2);
        myListView2 = (ListView) findViewById(R.id.listview2);
        myListView2.setAdapter(myArrayadapter2);
        mRef = FirebaseDatabase.getInstance().getReference("Prep").child("Dressings");

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                String value=dataSnapshot.getValue().toString();
                myArrayList.add(value);
                myArrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}