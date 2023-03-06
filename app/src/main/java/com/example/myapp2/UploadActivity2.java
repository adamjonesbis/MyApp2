package com.example.myapp2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UploadActivity2 extends AppCompatActivity {

    //date picker from https://www.youtube.com/watch?v=6UnxDgq_bLw&ab_channel=CodingWithMe
    ImageView uploadImage;
    Button saveButton;
    EditText uploadTopic, uploadDesc1, uploadLang;
    String imageUrl;
    Uri uri;
    DatePickerDialog datePickerDialog;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload2);

        uploadImage = findViewById(R.id.uploadImage);
        uploadDesc1 = findViewById(R.id.uploadDesc);
        uploadTopic = findViewById(R.id.uploadTopic);
        uploadLang = findViewById(R.id.uploadLang);
        saveButton = findViewById(R.id.saveButton);

        //String imagepic = "data:image/jpeg;base64,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";
        //Glide.with(this)
        //        .load(imagepic)
        //       .into(uploadImage);
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();

            } private void updateCalendar(){
                String Format= "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.ENGLISH);

                uploadDesc1.setText(sdf.format(calendar.getTime()));
            }
        };
        uploadDesc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(UploadActivity2.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImage.setImageURI(uri);
                        } else {
                            Toast.makeText(UploadActivity2.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
                ;
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }
    public void saveData(){

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Image")
                .child(uri.getLastPathSegment());
        AlertDialog.Builder builder = new AlertDialog.Builder(UploadActivity2.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();

                while (!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();

                imageUrl = urlImage.toString();
                uploadData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }

        });
    }
    public void uploadData(){
        String title = uploadTopic.getText().toString();
        String desc = uploadDesc1.getText().toString();
        String lang = uploadLang.getText().toString();


        DataClass2 dataClass = new DataClass2(title, desc, lang, imageUrl);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("Android tutorials2").child(currentDate)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(UploadActivity2.this, "Saved", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UploadActivity2.this, "You must fill all fields", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}