package com.santi.bearhacks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private EditText enterName;
    private EditText enterAge;
    private Button nextButton;
    private final int REQUEST_CODE = 2;

    //Trying to make an array to store data.
   /* private Question[] questionBank = new Question[]{

    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterName = findViewById(R.id.user_name);
        enterAge = findViewById(R.id.user_age);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess = enterName.getText().toString().trim();

                if (!guess.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, LogData.class);
                    intent.putExtra("guess", guess);
                    intent.putExtra("name", "bond");
                    intent.putExtra("age", 34);
                    startActivityForResult(intent, REQUEST_CODE);
                    //startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Enter guess",
                            Toast.LENGTH_SHORT)
                            .show();
                }

                // startActivity(new Intent(MainActivity.this, ShowGuess.class));
            }

            //HMM


        });
    }
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE) {
                assert data != null;
                String message = data.getStringExtra("message_back");

                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_LONG)
                        .show();
            }

        }


    }

