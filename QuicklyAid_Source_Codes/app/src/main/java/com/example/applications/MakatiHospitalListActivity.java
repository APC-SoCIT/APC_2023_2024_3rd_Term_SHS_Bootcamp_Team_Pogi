package com.example.applications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MakatiHospitalListActivity extends AppCompatActivity {

    private TextView goToMaps1, goToMaps2, goToMaps3, changeCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makati_hospital_list);

        goToMaps1 = findViewById(R.id.go_to_maps_1);
        goToMaps2 = findViewById(R.id.go_to_maps_2);
        goToMaps3 = findViewById(R.id.go_to_maps_3);
        changeCity = findViewById(R.id.change_city);

        goToMaps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Makati Medical Center in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Makati+Medical+Center/@14.5591512,121.0120064,17z/data=!3m1!4b1!4m6!3m5!1s0x3397c90becae09d3:0x2b157fdae0b0ee03!8m2!3d14.559146!4d121.0145867!16s%2Fm%2F05mr50z?entry=ttu"));
                startActivity(intent);
            }
        });

        goToMaps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Ospital ng Makati in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/xprRMNGbynVRCToh6"));
                startActivity(intent);
            }
        });

        goToMaps3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open St. Clare’s Medical Center in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/St.+Clare%E2%80%99s+Medical+Center,+Inc./@14.5599619,120.9829759,14.5z/data=!4m6!3m5!1s0x3397c90000000001:0x7214667dc20ffa2b!8m2!3d14.562984!4d121.0013004!16s%2Fg%2F11bzv_hr9t?entry=ttu"));
                startActivity(intent);
            }
        });

        changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the Hospital Places List activity
                Intent intent = new Intent(MakatiHospitalListActivity.this, HospitalListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
