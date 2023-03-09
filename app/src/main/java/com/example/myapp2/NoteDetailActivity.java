package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class NoteDetailActivity extends AppCompatActivity {
    EditText titleEditText,contentEditText;
    ImageButton saveNoteBtn;
    TextView pageTitleTextView;
    String title,content,docId;
    boolean isEditMode = false;
    TextView deleteNoteTextViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);

        saveNoteBtn.setOnClickListener( (v)-> saveNote());


    }

    void saveNote(){
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();
        if(noteTitle==null || noteTitle.isEmpty() ){
            titleEditText.setError("Title is required");
            return;
        }
}}