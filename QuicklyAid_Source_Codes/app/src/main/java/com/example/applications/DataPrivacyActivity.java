package com.example.applications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DataPrivacyActivity extends AppCompatActivity {

    private static final String TAG = "DataPrivacyActivity";
    private Button btnAgree;
    private Button btnNotAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_privacy);

        Log.d(TAG, "DataPrivacyActivity launched");

        btnAgree = findViewById(R.id.btnAgree);
        btnNotAgree = findViewById(R.id.btnNotAgree);

        btnAgree.setOnClickListener(v -> {
            Log.d(TAG, "Agree button clicked");
            Intent intent = new Intent(DataPrivacyActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnNotAgree.setOnClickListener(v -> {
            Log.d(TAG, "Not Agree button clicked");
            finishAffinity();
        });
    }
}
