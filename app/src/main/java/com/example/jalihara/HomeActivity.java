package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvUsername = findViewById(R.id.tvUsername);

        // Mengambil data username yang dikirimkan dari LoginActivity
        String username = getIntent().getStringExtra("username");

        if (username != null && !username.isEmpty()) {
            // Menampilkan username di TextView
            tvUsername.setText("Welcome, " + username + "!");
        }
    }

}