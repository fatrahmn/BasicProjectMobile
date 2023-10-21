package com.fatur.learnactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FavoriteActivity extends AppCompatActivity {

    TextView favoritePersonTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        favoritePersonTextView = findViewById(R.id.favoritePersonTV);

        Intent intent = getIntent();
        String favoritePerson = intent.getStringExtra(MainActivity.FAVORITE_KEY);
        favoritePersonTextView.setText(favoritePerson);

    }
}