package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.view.View.OnClickListener;

public class addChecklist extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    private Button BtnRead;
    private TextView textView;
    private DatabaseReference rootDatabaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_checklist);
        database = FirebaseDatabase.getInstance();
        Button BtnRead = findViewById(R.id.BtnRead);
        Button btnSave = findViewById(R.id.btnsave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editTextList = (EditText) findViewById(R.id.name);
                EditText editTextItem1 = (EditText) findViewById(R.id.Item1);
                EditText editTextItem2 = (EditText) findViewById(R.id.Item2);
                EditText editTextItem3 = (EditText) findViewById(R.id.Item3);
                EditText editTextItem4 = (EditText) findViewById(R.id.Item4);
                EditText editTextItem5 = (EditText) findViewById(R.id.Item5);

                String child = editTextList.getText().toString();
                myRef = database.getReference("Prep").child(child);


                myRef.child("Name").setValue(editTextList.getText().toString());
                myRef.child("1").setValue(editTextItem1.getText().toString());
                myRef.child("2").setValue(editTextItem2.getText().toString());
                myRef.child("3").setValue(editTextItem3.getText().toString());
                myRef.child("4").setValue(editTextItem4.getText().toString());
                myRef.child("5").setValue(editTextItem5.getText().toString());
            }
        });
    }
}