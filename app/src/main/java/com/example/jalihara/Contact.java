package com.example.jalihara;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Contact extends Fragment {

    private EditText editTextEmail;
    private TextView errorMessage;
    private TextView messageTextView;

    public Contact() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        editTextEmail = rootView.findViewById(R.id.editTextEmail);
        errorMessage = rootView.findViewById(R.id.errorMessage);
        Button buttonSent = rootView.findViewById(R.id.buttonSent);

        buttonSent.setOnClickListener(view -> {
            String email = editTextEmail.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                errorMessage.setText("Email can not be empty!");
                errorMessage.setVisibility(View.VISIBLE);
            } else if (!isValidEmail(email)) {
                errorMessage.setText("Email must end with @gmail.com");
                errorMessage.setVisibility(View.VISIBLE);
            }else {
                errorMessage.setText("Your email has been sent!");
                errorMessage.setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.endsWith("@gmail.com");
    }
}
