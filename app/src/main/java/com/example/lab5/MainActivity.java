package com.example.lab5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Amandeep Kaur
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    /** TextView to display output or messages */
    private TextView tv = null;

    /** EditText for user input */
    private EditText et = null;

    /** Button to trigger actions */
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        // Button click listener
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            checkPasswordForSpecialCharacters(password);
        });
    }

    /** This function checks if the password contains special characters. */
    private void checkPasswordForSpecialCharacters(String pw) {
        // Check if password contains any special characters
        if (containsSpecialCharacter(pw)) {
            // If password contains special characters
            Toast.makeText(this, "You shall pass", Toast.LENGTH_SHORT).show();
        } else {
            // If password does not contain special characters
            Toast.makeText(this, "You shall not pass", Toast.LENGTH_SHORT).show();
        }
    }

    /** This function checks if a password contains any special character. */
    private boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()_+={}[]|:;'<>,.?/";
        // Loop through password and check for any special character
        for (int i = 0; i < password.length(); i++) {
            if (specialCharacters.indexOf(password.charAt(i)) != -1) {
                return true; // Found special character
            }
        }
        return false; // No special character found
    }
}