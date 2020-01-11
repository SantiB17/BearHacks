package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.jar.Attributes;


public class SecondActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private int hours =0;
    private TextView hoursDisplay;
    private Serializable user;
    private Users Joe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        hoursDisplay = findViewById(R.id.hoursAmount);
 user =  getIntent().getSerializableExtra("Joe");
  Joe = (Users) user;
  //addHours(Joe.getHoursWorked());
  Log.d("User Num: ", " " + Joe.getHoursWorked());

    }

   /* public void displayHours(int v){

    }*/
    public void addHours(View view) {
        hours += 1;
        Joe.setHoursWorked(hours);
        Log.d("Hours: ", " " + Joe.getHoursWorked());
        hoursDisplay.setText(String.valueOf(hours));

    }
}
