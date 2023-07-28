package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TicketListActivity extends AppCompatActivity {

    private List<Ticket> ticketList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);

        // sample ticket data
        ticketList = new ArrayList<>();
        ticketList.add(new Ticket("Coldplay", 500000, "18 July 2023 at International Stadium Jakarta", R.drawable.image1));
        ticketList.add(new Ticket("Niki", 1000000, "18 July 2023 at International Stadium Jakarta", R.drawable.image2));
        ticketList.add(new Ticket("Dmasiv", 800000, "18 July 2023 at International Stadium Jakarta", R.drawable.image3));
        ticketList.add(new Ticket("vierratale", 700000, "18 July 2023 at International Stadium Jakarta", R.drawable.image4));
        ticketList.add(new Ticket("Aldi Taher", 5000000, "18 July 2023 at International Stadium Jakarta", R.drawable.image5));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        String username = getIntent().getStringExtra("username");
        if (id == R.id.action_settings) {
//            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item1){
            Intent intent = new Intent(TicketListActivity.this, HomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item2){
            Intent intent = new Intent(TicketListActivity.this, AboutUsActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item3){
            Intent intent = new Intent(TicketListActivity.this, TicketListActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item4){
            Intent intent = new Intent(TicketListActivity.this, LoginActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }

//        switch (item.getItemId()){
//            case R.id.action_settings:break;
//
//            default: return super.onOptionsItemSelected(item);
//        }
        return true;
    }

    private void openTicketForm(Ticket ticket) {
        String username = getIntent().getStringExtra("username");
        Intent intent = new Intent(this, TicketFormActivity.class);
        intent.putExtra("selected_ticket", ticket);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}