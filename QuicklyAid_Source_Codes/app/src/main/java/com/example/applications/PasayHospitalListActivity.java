package com.example.applications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PasayHospitalListActivity extends AppCompatActivity {

    private TextView pasayCityGeneralLink, airforceGeneralLink, sanJuanLink, adventistMedicalLink, changeCity;

    @Override
    protected void onCreate(


            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasay_hospital_list);

        pasayCityGeneralLink = findViewById(R.id.pasay_city_general_link);
        airforceGeneralLink = findViewById(R.id.airforce_general_link);
        sanJuanLink = findViewById(R.id.san_juan_link);
        adventistMedicalLink = findViewById(R.id.adventist_medical_link);
        changeCity = findViewById(R.id.change_city);

        pasayCityGeneralLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Pasay City General Hospital in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/T77ZxKLA1eJg48398"));
                startActivity(intent);
            }
        });

        airforceGeneralLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Air Force General Hospital in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/AdmPZy17DRQWbp9F9"));
                startActivity(intent);
            }
        });

        sanJuanLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open San Juan De Dios Hospital in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/bpKQhBgWnsMbDt326"));
                startActivity(intent);
            }
        });

        adventistMedicalLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Adventist Medical Center Manila in Google Maps
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/reGSCLFiczfVPEkRA"));
                startActivity(intent);
            }
        });

        changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to HospitalListActivity
                Intent intent = new Intent(PasayHospitalListActivity.this, HospitalListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
