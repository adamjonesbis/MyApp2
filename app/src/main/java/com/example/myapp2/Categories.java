package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        String name = getIntent().getStringExtra("Name");

        TextView nameTextView = findViewById(R.id.nameTextView);

       nameTextView.setText(name);


        }
       }

