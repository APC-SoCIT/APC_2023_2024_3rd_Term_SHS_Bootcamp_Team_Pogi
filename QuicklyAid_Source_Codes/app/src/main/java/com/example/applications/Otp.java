package com.example.applications;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Random;

public class Otp extends AppCompatActivity {

    String otp, phone;
    String message = "is your verification code.";
    Button button, verifyButton;
    EditText etOtp, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp); // Ensure this matches your XML layout file

        button = findViewById(R.id.sms);
        verifyButton = findViewById(R.id.verify);
        etOtp = findViewById(R.id.etOtp);
        etPhone = findViewById(R.id.etPhone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = etPhone.getText().toString();
                if (phone.length() == 11) {
                    if (ContextCompat.checkSelfPermission(Otp.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        generateAndSendOTP();
                    } else {
                        ActivityCompat.requestPermissions(Otp.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                    }
                } else {
                    Toast.makeText(Otp.this, "Please enter a valid 11-digit phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Otp2 activity
                Intent intent = new Intent(Otp.this, Otp2.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                generateAndSendOTP();
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void generateAndSendOTP() {
        otp = generateOTP();
        // etOtp.setText(otp); // Remove this line to prevent auto-filling

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(otp + " " + message);
        smsManager.sendMultipartTextMessage(phone, null, parts, null, null);

        Toast.makeText(this, "OTP sent: " + otp, Toast.LENGTH_SHORT).show(); // Inform the user (optional)
    }

    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
