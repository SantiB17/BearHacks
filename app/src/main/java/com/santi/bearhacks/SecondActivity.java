package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;



public class SecondActivity extends AppCompatActivity {


    private int hours =0;

    //index for a potential array of our data.
    private int index = 0;

 //   private Button button_G;
    private TextView hoursDisplay;
    private TextView daysPassed;
    private TextView timeView;
    private Serializable person;
    private Users Joe;
    private String currentDateTimeString;
    private int days;
    DatabaseReference reff;
    String priorKey;
    int []array = new int[7];


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
       daysPassed = findViewById(R.id.numdays);
        person =  getIntent().getSerializableExtra("Joe");
         Joe = (Users) person;
        this.priorKey = reff.child("Users").getKey();
  Log.d("User Num: ", " " + Joe.getHoursWorked());

    }


    public void graphView(View v) {
        Intent intent = new Intent(SecondActivity.this, GraphActivity.class);
        intent.putExtra("Joe",Joe);
        startActivity(intent);
    }

    //Once clicked change index position in the week array. (need to make an array)
    public void newDay(View view){
        if(index < 7) {
            days++;
            Joe.setHoursWorked(hours);
            hours = 0;
            hoursDisplay.setText(String.valueOf(hours));
            daysPassed.setText(String.valueOf(days));
            reff.child(this.priorKey).setValue(Joe);
            Joe.log[index]+= hours;

            index++;
        }
        else{
            //Keeps index range from 0 to 7
            index = 0;
            Log.d("Index: ", " " + index);
        }
    }

    public void addHours(View view) {

            if(hours < 24) {
                hours += 1;
                Joe.log[index]++;
                Log.d("Hours: ", " " + Joe.getHoursWorked());
                hoursDisplay.setText(String.valueOf(hours));
                // Joe.setHoursWorked(hours);
                reff.child(this.priorKey).setValue(Joe);
            }
            else{
                Toast.makeText(getApplicationContext(),"Hours in day exceeded!",Toast.LENGTH_SHORT).show();

            }


/*  Not useable for right now
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        int val = Integer.parseInt(dateTime) % 10;
        Log.d("DATEVAL: ", " "+ val);
        Log.d("DATETIME: ", " " + dateTime);
        */


    }
}
//CHANGE