package com.fatur.myimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText searchEditText;
    EditText sendEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchEditText = findViewById(R.id.keywordET);
        sendEditText = findViewById(R.id.sendET);
    }

    public void visitWeb(View view){
        Uri webAddress = Uri.parse("https://if.unmuhpnk.ac.id");

        Intent intent = new Intent(Intent.ACTION_VIEW, webAddress);
        startActivity(intent);
    }

    public void visitMap(View view){
        Uri coordinate = Uri.parse("geo:-0.111195,109.412423");

        Intent intent = new Intent(Intent.ACTION_VIEW, coordinate);
        startActivity(intent);
    }

    public void callPhone(View view){
        Uri phoneNumber = Uri.parse("tel:+6289664467986");

        Intent intent = new Intent(Intent.ACTION_VIEW, phoneNumber);
        startActivity(intent);
    }

    public void searchGoogle(View view){
        String keyword = searchEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, keyword);
        startActivity(intent);
    }

    public void sendText(View view){
        String text = sendEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setType("text/plain");
        startActivity(intent);
    }



}