package com.santi.bearhacks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;



public class SecondActivity extends AppCompatActivity {


    private int hours =0;
    private TextView hoursDisplay;
    private Serializable person;
    private Users Joe;
    DatabaseReference reff;
    String priorKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        reff = FirebaseDatabase.getInstance().getReference().child("Users");
       hoursDisplay = findViewById(R.id.hoursAmount);
        person =  getIntent().getSerializableExtra("Joe");
         Joe = (Users) person;
        this.priorKey = reff.child("Users").getKey();
  Log.d("User Num: ", " " + Joe.getHoursWorked());

    }

    public void addHours(View view) {
        hours += 1;
        Joe.setHoursWorked(hours);
        Log.d("Hours: ", " " + Joe.getHoursWorked());
        hoursDisplay.setText(String.valueOf(hours));
        Joe.setHoursWorked(hours);
        reff.child(this.priorKey).setValue(Joe);
      //  reff.push().setValue(Joe);
    }
}
