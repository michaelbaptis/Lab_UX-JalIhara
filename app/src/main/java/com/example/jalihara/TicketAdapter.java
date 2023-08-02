package com.example.jalihara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.List;

public class TicketAdapter extends ArrayAdapter<Ticket> {
    private Context context;
    private List<Ticket> ticketList;
    private String username;

    public TicketAdapter(Context context, List<Ticket> ticketList, String username) {
        super(context, 0, ticketList);
        this.context = context;
        this.ticketList = ticketList;
        this.username = username;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ticket ticket = ticketList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ticket_item, parent, false);
        }

        TextView ticketNameTextView = convertView.findViewById(R.id.ticketNameTextView);
        TextView ticketPriceTextView = convertView.findViewById(R.id.ticketPriceTextView);
        TextView ticketDecriptionTextView = convertView.findViewById(R.id.ticketDescriptionTextView);
        ImageView ticketimageView = convertView.findViewById(R.id.ticketImageView);

        ticketNameTextView.setText(ticket.getTitle());
        ticketDecriptionTextView.setText(ticket.getDescription());
        ticketPriceTextView.setText(String.format("$%.2f", ticket.getPrice()));
        ticketimageView.setImageResource(ticket.getImageResourceId());

        // Get the CardView and set its click listener if needed
        CardView cardView = convertView.findViewById(R.id.cardView);
        Button buyBtn = convertView.findViewById(R.id.buyBtn);

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTicketForm(ticket);
            }
        });

        return convertView;
    }

    private void openTicketForm(Ticket ticket) {
//        String username = getIntent().getStringExtra("username");
        Intent intent = new Intent(context, TicketFormActivity.class);
        intent.putExtra("selected_ticket", ticket);
        intent.putExtra("username", username);
        context.startActivity(intent);
    }
}