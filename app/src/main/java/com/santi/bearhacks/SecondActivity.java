package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;



public class SecondActivity extends AppCompatActivity {


    private int hours =0;
 //   private Button button_G;
    private TextView hoursDisplay;
    private TextView timeView;
    private Serializable person;
    private Users Joe;
    private String currentDateTimeString;
    DatabaseReference reff;
    String priorKey;


    private int test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

      //   loginButton = findViewById(R.id.login_button);
      //  button_G = findViewById(R.id.buttonG);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        reff = FirebaseDatabase.getInstance().getReference().child("Users");
       hoursDisplay = findViewById(R.id.hoursAmount);
        person =  getIntent().getSerializableExtra("Joe");
         Joe = (Users) person;
        this.priorKey = reff.child("Users").getKey();
  Log.d("User Num: ", " " + Joe.getHoursWorked());

    }

    public void graphView(View v) {
        Intent intent = new Intent(SecondActivity.this, GraphActivity.class);
        startActivity(intent);
    }
    public void addHours(View view) {
        hours += 1;
        Joe.setHoursWorked(hours);
        Log.d("Hours: ", " " + Joe.getHoursWorked());
        hoursDisplay.setText(String.valueOf(hours));
        Joe.setHoursWorked(hours);
        reff.child(this.priorKey).setValue(Joe);


      //  Calendar calendar = Calendar.getInstance();
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
       // String dateTime = simpleDateFormat.format(calendar.getTime());
       // Log.d("Display date: ", " " + dateTime);

      //  int val = Integer.parseInt(dateTime) % 10;





    }
}
