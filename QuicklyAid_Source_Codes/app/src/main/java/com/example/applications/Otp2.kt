package com.example.applications

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Otp2 : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSubmit: Button

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp2) // Ensure this matches your XML layout file

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        editTextName = findViewById(R.id.editTextName)
        editTextAddress = findViewById(R.id.editTextAddress)
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            submitUserData()
        }
    }

    private fun submitUserData() {
        val name = editTextName.text.toString().trim()
        val address = editTextAddress.text.toString().trim()
        val email = editTextEmail.text.toString().trim()

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Generate a unique ID for each user
        val userId = databaseReference.push().key

        // Create a User object
        val user = User(name, address, email)

        // Save the user under the unique ID
        if (userId != null) {
            databaseReference.child(userId).setValue(user)
            Toast.makeText(this, "Data submitted successfully", Toast.LENGTH_SHORT).show()

            // Navigate to Data Privacy Activity
            val intent = Intent(this, DataPrivacyActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Error submitting data", Toast.LENGTH_SHORT).show()
        }
    }
}
