package com.example.applications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class  TaguigHospitalListActivity extends AppCompatActivity {

    private TextView stLukesLink, recuencoLink, taguigDoctorsLink, taguigPaterosLink, changeCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taguig_hospital_list);

        stLukesLink = findViewById(R.id.go_to_maps_1);
        recuencoLink = findViewById(R.id.go_to_maps_2);
        taguigDoctorsLink = findViewById(R.id.go_to_maps_3);
        taguigPaterosLink = findViewById(R.id.go_to_maps_4);
        changeCity = findViewById(R.id.change_city);

        stLukesLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open St. Luke’s Medical Center – Global City in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/guFj76CTDJ4kaiVc9"));
                startActivity(intent);
            }
        });

        recuencoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Recuenco General Hospital in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/wJr6yw4KBEMACPr79"));
                startActivity(intent);
            }
        });

        taguigDoctorsLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Taguig Doctors Hospital in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/aWTwivGYBXysMsad7"));
                startActivity(intent);
            }
        });

        taguigPaterosLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Taguig Pateros District Hospital in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/FAn6HwSUknmWTa6z7"));
                startActivity(intent);
            }
        });

        changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HospitalPlacesListActivity
                Intent intent = new Intent(TaguigHospitalListActivity.this, HospitalListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
