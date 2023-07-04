package com.example.jalihara;

//import android.content.Intent;
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
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvErrorMessage = findViewById(R.id.tvErrorMessage);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                tvErrorMessage.setText(getString(R.string.username_required));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else if (TextUtils.isEmpty(password)) {
                tvErrorMessage.setText(getString(R.string.password_required));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else if (username.length() <= 5) {
                tvErrorMessage.setText(getString(R.string.username_length));
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else if (password.length() <= 8) {
                tvErrorMessage.setText(getString(R.string.password_length));
                tvErrorMessage.setVisibility(View.VISIBLE);
            }

        });
    }



}
