package com.fatur.learnactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText favoritePersonEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        favoritePersonEditText = findViewById(R.id.favoritePersonET);
    }

    public void launchCyanActyvity(View view) {
        Intent intent = new Intent (this, CyanActivity.class);
        startActivity(intent);
    }
    public static final String FAVORITE_KEY = "A591";
    public void visitWebsite(View view) {
        Uri uri = Uri.parse("https://if.unmuhpnk.ac.id");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void sendFavoritePerson(View view) {
        String favoritePerson = favoritePersonEditText.getText().toString();
        Intent intent = new Intent(this, FavoriteActivity.class);
        intent.putExtra(FAVORITE_KEY, favoritePerson);
        startActivity(intent);
    }
}