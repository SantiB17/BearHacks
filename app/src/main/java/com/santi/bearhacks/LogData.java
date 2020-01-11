package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogData extends AppCompatActivity {
    private TextView showGuessTextview;
  //  private EditText enterHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_data);
     //   enterHours = findViewById(R.id.input_data);

        Bundle extra = getIntent().getExtras();

        showGuessTextview = findViewById(R.id.received_text);

        if (extra != null) {
            showGuessTextview.setText(extra.getString("guess"));
            Log.d("Name extra", "onCreate: " + extra.getString("name"));
            Log.d("Name extra 2", "onCreate: " + extra.getInt("age"));
        }

        showGuessTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "From Second Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

//        if (getIntent().getStringExtra("guess") != null) {
//            Log.d("Stuff", " " + getIntent().getStringExtra("name"));
//            showGuessTextview.setText(getIntent().getStringExtra("guess"));
//        }
    }
}
