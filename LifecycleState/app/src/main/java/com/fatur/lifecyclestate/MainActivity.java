package com.fatur.lifecyclestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText yearEditText;
    TextView studentNumberTextView;
    String twoDigit;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MAIN ACTIVITY", "CREATED");
        yearEditText = findViewById(R.id.yearRegisterET);
        studentNumberTextView = findViewById(R.id.studentNumberTV);
        if (savedInstanceState !=null) {
            twoDigit = savedInstanceState.getString("TWODIGIT_KEY");
            studentNumberTextView.setText(twoDigit);
        }
    }

    public void getTwoDigit(View view){
        String yearString = yearEditText.getText().toString();
        twoDigit = yearString.substring(yearString.length() - 2);
        studentNumberTextView.setText(twoDigit);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TWODIGIT_KEY", twoDigit);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MAIN ACTIVITY", "STARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MAIN ACTIVITY", "RESUMED");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MAIN ACTIVITY", "PAUSED");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MAIN ACTIVITY", "STOPPED");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MAIN ACTIVITY", "DESTROYED");
    }


}