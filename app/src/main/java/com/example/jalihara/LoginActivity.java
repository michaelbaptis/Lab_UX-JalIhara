package com.example.jalihara;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvErrorMessage = findViewById(R.id.tvErrorMessage);
        Button btnLogin = findViewById(R.id.btnLogin);

        findViewById(R.id.btnLogin).setOnClickListener(view -> {
            // Mengambil nilai username dan password
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                // Validasi jika username kosong
                tvErrorMessage.setText(getString(R.string.username_required));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else if (TextUtils.isEmpty(password)) {
                // Validasi jika password kosong
                tvErrorMessage.setText(getString(R.string.password_required));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else if (username.length() <= 5) {
                // Validasi panjang username
                tvErrorMessage.setText(getString(R.string.username_length));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else if (password.length() <= 8) {
                // Validasi panjang password
                tvErrorMessage.setText(getString(R.string.password_length));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else {
                // Jika semua validasi sukses
                // Membuat Intent untuk pindah ke HomeActivity
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                // Mengirim data username ke HomeActivity
                intent.putExtra("username", username);
                startActivity(intent);
                finish(); // Opsional: menutup LoginActivity setelah pindah ke HomeActivity
            }
        });


    }



}
