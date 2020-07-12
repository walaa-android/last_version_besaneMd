package com.example.besanemd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.besanemd.R;
import com.example.besanemd.fragments.HomeFragment;
import com.example.besanemd.fragments.ProfileFragment;
import com.example.besanemd.fragments.TipsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottom_navigation= findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_home:

                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                        break;

                    case R.id.action_tips:

                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new TipsFragment()).commit();
                        break;

                    case R.id.action_profile:

                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ProfileFragment()).commit();
                        bottom_navigation.getItemTextAppearanceActive();
                        break;
                }
                return true;
            }
        });
    }


}