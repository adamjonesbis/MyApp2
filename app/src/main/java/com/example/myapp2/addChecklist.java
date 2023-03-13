package com.example.myapp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.View.OnClickListener;

import java.util.ArrayList;

//See references.txt to get see where code was taken from
//https://www.youtube.com/watch?v=F71ON3F97jE&ab_channel=HelloCoders - adding data to firebase
public class addChecklist extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    private Button BtnRead;
    private TextView textView;
    private DatabaseReference rootDatabaseref;
    ListView myListView;


    ArrayList<String> myArrayList = new ArrayList<>();

    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_checklist);
        database = FirebaseDatabase.getInstance();

        Button btnSave = findViewById(R.id.btnsave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextList = (EditText) findViewById(R.id.name);

                myRef = database.getReference("Prep").child("EOD");
                myRef.setValue(editTextList.getText().toString());
                editTextList.setText("");
                ArrayAdapter<String> myArrayadapter = new ArrayAdapter<String>(addChecklist.this,android.R.layout.simple_list_item_1,myArrayList);

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
            }
        });
        ArrayAdapter<String> myArrayadapter = new ArrayAdapter<String>(addChecklist.this,android.R.layout.simple_list_item_1,myArrayList);

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


    }
}