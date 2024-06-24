package com.example.applications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SelectCityActivity extends AppCompatActivity {

    private Button taguigButton, makatiButton, pasayButton, backButton;
    private boolean isForHotlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        taguigButton = findViewById(R.id.taguig_button);
        makatiButton = findViewById(R.id.makati_button);
        pasayButton = findViewById(R.id.pasay_button);
        backButton = findViewById(R.id.back_button);

        // Retrieve the flag to determine if we are selecting for hotlines or hospital lists
        isForHotlines = getIntent().getBooleanExtra("isForHotlines", false);

        taguigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (isForHotlines) {
                    intent = new Intent(SelectCityActivity.this, TaguigEmergencyHotlinesActivity.class);
                } else {
                    intent = new Intent(SelectCityActivity.this, TaguigEmergencyHotlinesActivity.class);
                }
                startActivity(intent);
            }
        });

        makatiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (isForHotlines) {
                    intent = new Intent(SelectCityActivity.this, MakatiEmergencyHotlinesActivity.class);
                } else {
                    intent = new Intent(SelectCityActivity.this, MakatiEmergencyHotlinesActivity.class);
                }
                startActivity(intent);
            }
        });

        pasayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (isForHotlines) {
                    intent = new Intent(SelectCityActivity.this, PasayEmergencyHotlinesActivity.class);
                } else {
                    intent = new Intent(SelectCityActivity.this, PasayEmergencyHotlinesActivity.class);
                }
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCityActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
