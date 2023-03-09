package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class notes extends AppCompatActivity {

    FloatingActionButton addNoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        addNoteBtn = findViewById(R.id.add_note_btn);

        addNoteBtn.setOnClickListener((v)-> startActivity(new Intent(notes.this, NoteDetailActivity.class)));

    }
}