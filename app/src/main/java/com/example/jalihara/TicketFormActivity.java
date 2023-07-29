package com.example.jalihara;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TicketFormActivity extends AppCompatActivity {

    private EditText customerNameEditText;
    private EditText quantityEditText;
    private RadioGroup boothTypeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        setContentView(R.layout.activity_ticket_form);

        Ticket selectedTicket = (Ticket) intent.getSerializableExtra("selected_ticket");

        if(selectedTicket!= null) {
            TextView ticketNameTextView = findViewById(R.id.ticketNameTextView);
            TextView ticketPriceTextView = findViewById(R.id.ticketPriceTextView);

            ticketNameTextView.setText(selectedTicket.getTitle());
            ticketPriceTextView.setText(String.format("Rp %.2f", selectedTicket.getPrice()));
        }

        // Find views by their IDs
        customerNameEditText = findViewById(R.id.buyerNameEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        boothTypeRadioGroup = findViewById(R.id.radioGroupOptions);

        Button submitButton = findViewById(R.id.buyButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSubmit();
            }
        });

        ImageView showTicketsButton = findViewById(R.id.backBtn);

        // Set a click listener to the button
        showTicketsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openTicketListActivity();
            }
        });

    }

    private void openTicketListActivity() {
        String username = getIntent().getStringExtra("username");
        Intent intent = new Intent(TicketFormActivity.this, TicketListActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    private void validateAndSubmit() {

        String customerName = customerNameEditText.getText().toString().trim();
        String quantityStr = quantityEditText.getText().toString().trim();

        TextView errorMessageTextView = findViewById(R.id.errorMessageTextView);

        // Check if customer name is filled
        if (customerName.isEmpty()) {
            errorMessageTextView.setText("Customer name must be filled");
            errorMessageTextView.setTextColor(Color.WHITE);
            return;
        }

        // Check if quantity is filled and more than 0
        if (quantityStr.isEmpty()) {
            errorMessageTextView.setText("Quantity must be filled");
//            errorMessageTextView.setVisibility(View.VISIBLE);
            errorMessageTextView.setTextColor(Color.WHITE);
            return;
        }

        int quantity = Integer.parseInt(quantityStr);
        if (quantity <= 0) {
            errorMessageTextView.setText("Quantity must be more than 0.");
//            errorMessageTextView.setVisibility(View.VISIBLE);
            errorMessageTextView.setTextColor(Color.WHITE);
            return;
        }

        // Check if a booth type is selected
        int selectedBoothTypeId = boothTypeRadioGroup.getCheckedRadioButtonId();
        if (selectedBoothTypeId == -1) {
            errorMessageTextView.setText("Booth type must be selected");
//            errorMessageTextView.setVisibility(View.VISIBLE);
            errorMessageTextView.setTextColor(Color.WHITE);
            return;
        }

        String username = getIntent().getStringExtra("username");
        int base = ContextCompat.getColor(this, R.color.base);
        errorMessageTextView.setTextColor(base);
        Intent intent = new Intent(TicketFormActivity.this, HomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}