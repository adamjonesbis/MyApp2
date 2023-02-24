package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.security.Key;

public class DetailActivity extends AppCompatActivity {
    TextView detailDesc, detailTitle, detailLang;
    ImageView detailImage;
    FloatingActionButton deleteButton2, editButton, recipeButton;
    String Key="";
   //int key = Integer.parseInt(key1);
    String imageUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        deleteButton2 = findViewById(R.id.deleteButton2);
        editButton = findViewById(R.id.editButton);
        detailLang = findViewById(R.id.detailLang);
        recipeButton = findViewById(R.id.recipeButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailLang.setText(bundle.getString("Language"));
            imageUrl = bundle.getString("Image");
             Key = bundle.getString("Key");

            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
         deleteButton2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Android tutorials");
                 FirebaseStorage storage = FirebaseStorage.getInstance();

                 StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                 storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void unused) {
                       reference.child(Key).removeValue();
                         Toast.makeText(DetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                       finish();
                     }
                 });
             }
         });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("Title", detailTitle.getText().toString())
                        .putExtra("Description", detailDesc.getText().toString())
                        .putExtra("Language", detailLang.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("key", Key);
                startActivity(intent);
            }
        });
        recipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailActivity.this,prepView2.class);
                startActivity(intent);
            }
        });
            }


}