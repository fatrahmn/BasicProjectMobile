package com.fatur.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ORDER = "ORDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public void orderOne(View view) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ORDER, 1);
        setResult(RESULT_OK, intent);
        finish();
    }
}