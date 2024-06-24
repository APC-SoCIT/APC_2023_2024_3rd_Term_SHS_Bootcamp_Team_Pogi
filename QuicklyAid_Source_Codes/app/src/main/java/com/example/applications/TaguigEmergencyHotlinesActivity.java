package com.example.applications;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class TaguigEmergencyHotlinesActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PERMISSION = 1;
    private Button fireHotlineButton, medicalHotlineButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taguig_emergency_hotlines);

        fireHotlineButton = findViewById(R.id.fire_hotline_button);
        medicalHotlineButton = findViewById(R.id.medical_hotline_button);
        backButton = findViewById(R.id.back_button);

        fireHotlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall("09958133369");
            }
        });

        medicalHotlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall("09958133369");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaguigEmergencyHotlinesActivity.this, SelectCityActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void makeCall(String phoneNumber) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            try {
                startActivity(callIntent);
            } catch (Exception e) {
                Toast.makeText(this, "Call failed. Please try again.", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall("09958133369");
            } else {
                Toast.makeText(this, "Permission to make calls was denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
