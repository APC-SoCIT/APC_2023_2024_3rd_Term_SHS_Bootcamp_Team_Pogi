package com.example.applications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button selectCityButton, viewHospitalListButton;
    private ImageButton fireButton, medicalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectCityButton = findViewById(R.id.select_city_button);
        fireButton = findViewById(R.id.fire_button);
        medicalButton = findViewById(R.id.medical_button);

        selectCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectCityActivity.class);
                intent.putExtra("isForHotlines", true);
                startActivity(intent);
            }
        });

        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
                startActivity(intent);
            }
        });

        medicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HospitalListActivity.class);
                startActivity(intent);
            }
        });
    }
}
