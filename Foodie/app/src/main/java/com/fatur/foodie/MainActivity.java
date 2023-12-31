package com.fatur.foodie;

import static com.fatur.foodie.DetailActivity.EXTRA_ORDER;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final int ORDER_REQUEST = 1;

    private String foodName = "Fried Rice";
    public static final String EXTRA_FOOD_NAME = "NAME";

    private byte quantity = 0;
    private TextView quantityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "onCreate");
        quantityTextView = findViewById(R.id.quantityTextView);
        if (savedInstanceState != null) {
            quantity = savedInstanceState.getByte("SAVED_QUANTITY");
            quantityTextView.setText(Byte.toString(quantity));
        }
    }

    public void addOne(View view) {
        quantity++;
        quantityTextView.setText(Byte.toString(quantity));
    }

    public void substractOne(View view) {
        quantity--;
        quantityTextView.setText(Byte.toString(quantity));
    }

    public void launchDetailActivity(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
        intent.putExtra(EXTRA_FOOD_NAME, foodName);
        startActivityForResult(intent, ORDER_REQUEST);
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data
    ) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ORDER_REQUEST) {
            if (resultCode == RESULT_OK) {
                int orderRequest = data.getIntExtra(EXTRA_ORDER,
                        0);
                quantityTextView.setText(String.valueOf(orderRequest));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putByte("SAVED_QUANTITY", quantity);
    }

    public void launchAboutActivity(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }


}