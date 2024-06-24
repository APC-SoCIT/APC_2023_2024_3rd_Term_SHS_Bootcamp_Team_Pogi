package com.example.applications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HospitalListActivity extends AppCompatActivity {

    private Button taguigButton, makatiButton, pasayButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);

        taguigButton = findViewById(R.id.taguig_button);
        makatiButton = findViewById(R.id.makati_button);
        pasayButton = findViewById(R.id.pasay_button);
        backButton = findViewById(R.id.back_button);

        taguigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalListActivity.this, TaguigHospitalListActivity.class);
                startActivity(intent);
            }
        });

        makatiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalListActivity.this, MakatiHospitalListActivity.class);
                startActivity(intent);
            }
        });

        pasayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalListActivity.this, PasayHospitalListActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
