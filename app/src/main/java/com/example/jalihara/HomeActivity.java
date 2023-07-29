package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

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

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.banner6, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
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
            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item2){
            Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item3){
            Intent intent = new Intent(HomeActivity.this, TicketListActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item4){
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
            return true;
        }

        return true;
    }



}