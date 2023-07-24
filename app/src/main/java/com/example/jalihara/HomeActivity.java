package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

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

//        Button btnContactUs = findViewById(R.id.btnContactUs);
//        Button btnAboutUs = findViewById(R.id.btnAboutUs);
//
//        btnContactUs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Tambahkan kode untuk berpindah ke halaman ContactUs
//                Intent intent = new Intent(HomeActivity.this, ContactUs.class);
//                startActivity(intent);
//            }
//        });
//
//        btnAboutUs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Tambahkan kode untuk berpindah ke halaman AboutUs
//                Intent intent = new Intent(HomeActivity.this, AboutUs.class);
//                startActivity(intent);
//            }
//        });
    }

}
