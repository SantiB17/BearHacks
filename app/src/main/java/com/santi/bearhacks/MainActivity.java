package com.santi.bearhacks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
  //  ArrayList<Users> list = new ArrayList<Users>();
  Users NameJ = new Users();
    private EditText enterName;
    private EditText enterPassword;
    private Button loginButton;
    private int counter = 4;

    //Trying to make an array to store data.
   /* private Question[] questionBank = new Question[]{

    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterName = findViewById(R.id.user_name);
        enterPassword = findViewById(R.id.user_password);
        loginButton = findViewById(R.id.login_button);

        if(NameJ != null) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            Log.d("Name", NameJ.getName());
            intent.putExtra("Joe", NameJ);
            startActivity(intent);
        }
        
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(enterName.getText().toString(),enterPassword.getText().toString());
            }

        });
    }

    public void validate(String userName, String password) {
        if(userName.equals("Joe") && password.equals("rogan")) {
             NameJ = new Users();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            Log.d("Name", NameJ.getName());
            intent.putExtra("Joe", NameJ);
            startActivity(intent);
        }
        else{
            counter --;
            Toast.makeText(getApplicationContext(),"Number of attempts: " + counter,Toast.LENGTH_SHORT).show();

            if(counter == 0){
                loginButton.setEnabled(false);
            }
        }
    }


}

