package com.example.jalihara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jalihara.Adapters.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class AboutUsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new TabAdapter(getSupportFragmentManager(), getLifecycle());

        setupAboutUs();
        setupContactUs();
    }

    private void setupAboutUs() {
        viewPager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("About Us"));
        tabLayout.addTab(tabLayout.newTab().setText("Contact Us"));

        // sinkronin pas pilih tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // sinkronin pas swipe fragment
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
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
            Intent intent = new Intent(AboutUsActivity.this, HomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item2){
            Intent intent = new Intent(AboutUsActivity.this, AboutUsActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item3){
            Intent intent = new Intent(AboutUsActivity.this, TicketListActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.sub_item4){
            Intent intent = new Intent(AboutUsActivity.this, LoginActivity.class);
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

    //    contact us

    private void setupContactUs() {
        // Initialize the views

    }

}
