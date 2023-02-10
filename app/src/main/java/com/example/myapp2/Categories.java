package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
//See references.txt to get see where code was taken from
public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        String name = getIntent().getStringExtra("Name");
        String description = getIntent().getStringExtra("Description");

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView tvdescription = findViewById(R.id.tvDescription);

       nameTextView.setText(name);
       tvdescription.setText(description);


        }
       }

