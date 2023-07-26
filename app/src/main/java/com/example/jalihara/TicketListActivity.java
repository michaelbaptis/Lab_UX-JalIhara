package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TicketListActivity extends AppCompatActivity {

    private List<Ticket> ticketList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);

        // sample ticket data
        ticketList = new ArrayList<>();
        ticketList.add(new Ticket("Coldplay", 500000, "18 July 2023 at International Stadium Jakarta", R.drawable.ticket_1));
        ticketList.add(new Ticket("Niki", 1000000, "18 July 2023 at International Stadium Jakarta", R.drawable.ticket_2));
        ticketList.add(new Ticket("Dmasiv", 800000, "18 July 2023 at International Stadium Jakarta", R.drawable.ticket_3));
        ticketList.add(new Ticket("vierratale", 700000, "18 July 2023 at International Stadium Jakarta", R.drawable.ticket_4));
        ticketList.add(new Ticket("Aldi Taher", 5000000, "18 July 2023 at International Stadium Jakarta", R.drawable.ticket_5));

        ListView listView = findViewById(R.id.listView);
        TicketAdapter ticketAdapter = new TicketAdapter(this, ticketList);
        listView.setAdapter(ticketAdapter);
//
//
//        // handle click events on tickets
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Ticket selectedTicket = ticketList.get(position);
//                openTicketForm(selectedTicket);
//            }
//        });
    }

    private void openTicketForm(Ticket ticket) {
        Intent intent = new Intent(this, TicketFormActivity.class);
        intent.putExtra("selected_ticket", ticket);
        startActivity(intent);
    }
}